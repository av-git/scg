package br.jus.trt8.scg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: GECJ
 *
 */
@Entity
public class GECJ implements Serializable {

	private static final long serialVersionUID = 5039836841796414112L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GECJ_SEQ")
    @SequenceGenerator(sequenceName = "gecj_seq", allocationSize = 1, name = "GECJ_SEQ")
	private Long id;
	
	private Integer mes;
	
	private Integer ano;
	
	@Temporal(TemporalType.DATE)
	private Date dataCalculo;
	
	private Boolean deAcordo;
	
	private String justificativa;
	
	private boolean aprovado;
	
	private String parecer;
	
	@OneToOne
	private Juiz juiz;
	
	//@OneToMany(mappedBy="gecj") // relacionamento bi derecional
	@OneToMany(cascade=CascadeType.ALL, fetch= FetchType.LAZY) 
	@JoinColumn(name="gecj_id", referencedColumnName="id") // relacionamento unidirecional
	@Basic(fetch=FetchType.LAZY)
	private List<GecjItem> dias;
	
	public GECJ() {
		super();
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return this.ano;
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
		return this.deAcordo;
	}

	public void setDeAcordo(Boolean deAcordo) {
		this.deAcordo = deAcordo;
	}

	public String getJustificativa() {
		return this.justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public boolean getAprovado() {
		return this.aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getParecer() {
		return this.parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public void adicionarDia(GecjItem dia) {
		if (dias == null) {
			dias = new ArrayList<GecjItem>();
		}
		
		dias.add(dia);
	}

	public List<GecjItem> getDias() {
		return dias;
	}

	public void setDias(List<GecjItem> dias) {
		this.dias = dias;
	}

	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}

	@Override
	public String toString() {
		return "GECJ [id=" + id + ", mes=" + mes + ", ano=" + ano + ", dataCalculo=" + dataCalculo + ", deAcordo="
				+ deAcordo + ", justificativa=" + justificativa + ", aprovado=" + aprovado + ", parecer=" + parecer
				+ ", juiz=" + juiz + "]";
	}
	
}
