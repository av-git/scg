package br.jus.trt8.scg.model;

import java.io.Serializable;

import javax.persistence.Column;

//@Embeddable
public class ItemGecjPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//@Column(nullable = false)
	//private GECJ gecj;
	private Long id;

	@Column(name="versao", nullable=false)
	private String versao;
	
	@Column(name="dia", nullable=false)
	private Integer dia;

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	
}
