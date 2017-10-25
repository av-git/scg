package br.jus.trt8.scg.vo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MesVO  {

	/** Atributos **/

	private int mes;
	
	private int ano;
	
	/** Construtores **/
	
	public MesVO() {
		super();
	}

	public MesVO(int mes, int ano) {
		super();
		this.mes = mes;
		this.ano = ano;
	}

	public MesVO(MesVO mesVo) {
		this.mes = mesVo.getMes();
		this.ano = mesVo.getAno();
	}

	
	private String getDiaDaSemanaPorExtenso(int diaDaSemana) {
		switch ( diaDaSemana ) {
		  case Calendar.SUNDAY: return "Domingo";
		  case Calendar.MONDAY: return "Segunda";
		  case Calendar.TUESDAY: return "Ter�a";
		  case Calendar.WEDNESDAY: return "Quarta";
		  case Calendar.THURSDAY: return "Quinta";
		  case Calendar.FRIDAY: return "Sexta";
		  case Calendar.SATURDAY: return "S�bado";
		  default: return "";
		}
	}
	
	/** Acessores e Modificadores **/
	
	
	public String getDescricao() {
		String mes = "";
		switch ( this.mes ) {
		  case 0: mes = "Janeiro"; break;
		  case 1: mes = "Fevereiro"; break;
		  case 2: mes = "Mar�o"; break;
		  case 3: mes = "Abril"; break;
		  case 4: mes = "Maio"; break;
		  case 5: mes = "Junho"; break;
		  case 6: mes = "Julho"; break;
		  case 7: mes = "Agosto"; break;
		  case 8: mes = "Setembro"; break;
		  case 9: mes = "Outubro"; break;
		  case 10: mes = "Novembro"; break;
		  case 11: mes = "Dezembro"; break;
		  default: break;
		}
		return ( mes + " de " + this.ano );
	}

	public String getPorExtenso() {
		String mes = "";
		switch ( this.mes ) {
		  case 1: mes = "Janeiro"; break;
		  case 2: mes = "Fevereiro"; break;
		  case 3: mes = "Mar�o"; break;
		  case 4: mes = "Abril"; break;
		  case 5: mes = "Maio"; break;
		  case 6: mes = "Junho"; break;
		  case 7: mes = "Julho"; break;
		  case 8: mes = "Agosto"; break;
		  case 9: mes = "Setembro"; break;
		  case 10: mes = "Outubro"; break;
		  case 11: mes = "Novembro"; break;
		  case 12: mes = "Dezembro"; break;
		  default: break;
		}
		return ( mes + " de " + this.ano );
	}
	
	public int getMes() {
		return this.mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getPrimeiroDia() {
		Calendar dia = new GregorianCalendar(this.ano,this.mes,1,0,0,0);
		return this.getDiaDaSemanaPorExtenso(dia.get(Calendar.DAY_OF_WEEK));
	}
	
	public String getSegundoDia() {
		Calendar dia = new GregorianCalendar(this.ano,this.mes,2,0,0,0);
		return this.getDiaDaSemanaPorExtenso(dia.get(Calendar.DAY_OF_WEEK));
	}
	
	public String getTerceiroDia() {
		Calendar dia = new GregorianCalendar(this.ano,this.mes,3,0,0,0);
		return this.getDiaDaSemanaPorExtenso(dia.get(Calendar.DAY_OF_WEEK));
	}
	
	public String getQuartoDia() {
		Calendar dia = new GregorianCalendar(this.ano,this.mes,4,0,0,0);
		return this.getDiaDaSemanaPorExtenso(dia.get(Calendar.DAY_OF_WEEK));
	}
	
	public String getQuintoDia() {
		Calendar dia = new GregorianCalendar(this.ano,this.mes,5,0,0,0);
		return this.getDiaDaSemanaPorExtenso(dia.get(Calendar.DAY_OF_WEEK));
	}
	
	public String getSextoDia() {
		Calendar dia = new GregorianCalendar(this.ano,this.mes,6,0,0,0);
		return this.getDiaDaSemanaPorExtenso(dia.get(Calendar.DAY_OF_WEEK));
	}
	
	public String getSetimoDia() {
		Calendar dia = new GregorianCalendar(this.ano,this.mes,7,0,0,0);
		return this.getDiaDaSemanaPorExtenso(dia.get(Calendar.DAY_OF_WEEK));
	}

	/**
	 * Obtem o {@link MesVO} configurado com mes e ano referente ao mes anterior
	 * 
	 * @return {@link MesVO}
	 */
	public static MesVO obterReferenciaMesAnterior() {
		Calendar mesAnterior = Calendar.getInstance();
		mesAnterior.add(Calendar.MONTH,-1);
		return new MesVO(mesAnterior.get(Calendar.MONTH),mesAnterior.get(Calendar.YEAR));
	}
	
	public static MesVO obterReferenciaMesAtual() {
		Calendar calendario = Calendar.getInstance();
		return new MesVO(calendario.get(Calendar.MONTH),calendario.get(Calendar.YEAR));
	}
	
	public static Date getDataUltimoDiaMes(MesVO mesVO) {
		
		Calendar dataUltimoDiaMesAnterior = Calendar.getInstance();
		dataUltimoDiaMesAnterior.set(Calendar.YEAR, mesVO.getAno());
		dataUltimoDiaMesAnterior.set(Calendar.MONTH, mesVO.getMes() - 1);
		dataUltimoDiaMesAnterior.set(Calendar.DAY_OF_MONTH, dataUltimoDiaMesAnterior.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		return dataUltimoDiaMesAnterior.getTime();
	}
}