package br.jus.trt8.scg.dto;

/**
 * DTO implementation class for Entity: Vara
 *
 */

public class VaraDto {

	private Long id;
	
	private String nome;

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
	  
}
