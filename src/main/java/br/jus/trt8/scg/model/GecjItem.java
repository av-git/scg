package br.jus.trt8.scg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: GecjItem
 *
 */
@Entity
public class GecjItem implements Serializable  {
	
	private static final long serialVersionUID = 1510966282885087116L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GECJITEM_SEQ")
    @SequenceGenerator(sequenceName = "gecjitem_seq", allocationSize = 1, name = "GECJITEM_SEQ")
	private Long id;
	
	//@ManyToOne // para relacionamento bidirecional
	//private GECJ gecj;
	
	private Integer dia;
	
	private Boolean util;
	
	private Boolean gratificavel;
	
	private Boolean emVaraHabilitada;
	
	private String tipoEvento;
	
	private String subTipoEvento;
	
	private String motivo;
	
	private String versao;
	
	private String finalidadeEvento;
	
	private String auxilio;
	
	private Boolean deAcordo;
	
	private String justificativa;
	
	private String deferimento;
	
	private String parecer;
	
	public GecjItem() {
		super();
	}

	public Integer getDia() {
		return this.dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Boolean getUtil() {
		return this.util;
	}

	public void setUtil(Boolean util) {
		this.util = util;
	}

	public Boolean getGratificavel() {
		return this.gratificavel;
	}

	public void setGratificavel(Boolean gratificavel) {
		this.gratificavel = gratificavel;
	}

	public Boolean getEmVaraHabilitada() {
		return this.emVaraHabilitada;
	}

	public void setEmVaraHabilitada(Boolean emVaraHabilitada) {
		this.emVaraHabilitada = emVaraHabilitada;
	}

	public String getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getSubTipoEvento() {
		return this.subTipoEvento;
	}

	public void setSubTipoEvento(String subTipoEvento) {
		this.subTipoEvento = subTipoEvento;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getFinalidadeEvento() {
		return this.finalidadeEvento;
	}

	public void setFinalidadeEvento(String finalidadeEvento) {
		this.finalidadeEvento = finalidadeEvento;
	}

	public String getAuxilio() {
		return this.auxilio;
	}

	public void setAuxilio(String auxilio) {
		this.auxilio = auxilio;
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

	public String getDeferimento() {
		return this.deferimento;
	}

	public void setDeferimento(String deferimento) {
		this.deferimento = deferimento;
	}

	public String getParecer() {
		return this.parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	@Override
	public String toString() {
		return "GecjItem [id=" + id + ", dia=" + dia + ", util=" + util + ", gratificavel=" + gratificavel
				+ ", emVaraHabilitada=" + emVaraHabilitada + ", tipoEvento=" + tipoEvento + ", subTipoEvento="
				+ subTipoEvento + ", motivo=" + motivo + ", versao=" + versao + ", finalidadeEvento=" + finalidadeEvento
				+ ", auxilio=" + auxilio + ", deAcordo=" + deAcordo + ", justificativa=" + justificativa
				+ ", deferimento=" + deferimento + ", parecer=" + parecer + "]";
	}
	
	
	
/*
	public GECJ getGecj() {
		return gecj;
	}

	public void setGecj(GECJ gecj) {
		this.gecj = gecj;
	}
*/
	
}
