package br.jus.trt8.scg.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Dto implementation class for Entity: GECJ
 *
 */
public class GECJDto  {

    
	private Long id;
	
	private Integer mes;
	
	private Integer ano;
	
	@Temporal(TemporalType.DATE)
	private Date dataCalculo;
	
	private Boolean deAcordo;
	
	private String justificativa;
	
	private boolean aprovado;
	
	private String parecer;
	
	//private Juiz juiz;
	
	//private List<GecjItem> dias;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Date getDataCalculo() {
		return dataCalculo;
	}

	public void setDataCalculo(Date dataCalculo) {
		this.dataCalculo = dataCalculo;
	}

	public Boolean getDeAcordo() {
		return deAcordo;
	}

	public void setDeAcordo(Boolean deAcordo) {
		this.deAcordo = deAcordo;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}
		
}
