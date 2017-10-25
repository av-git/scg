package br.jus.trt8.scg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Juiz
 *
 */
@Entity
@Table(name = "JUIZ")
public class Juiz implements Serializable {

	private static final long serialVersionUID = -6457531594496946550L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JUIZ_SEQ")
    @SequenceGenerator(sequenceName = "juiz_seq", allocationSize = 1, name = "JUIZ_SEQ")
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String cpf;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Juiz [id=" + id + ", nome=" + nome + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
