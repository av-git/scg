package br.jus.trt8.scg.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Utilizar nas entidades quando o banco de dados possuir a estrategia de geracao dos id por "IDENTITY"
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntity implements Serializable, Cloneable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.id == null) {
			return false;
		}

		if (obj instanceof AbstractEntity && obj.getClass().equals(getClass())) {
			return this.id.equals(((AbstractEntity) obj).id);
		}

		return false;
	}

}
