package br.jus.trt8.scg.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

/**
 * DTO implementation class for Entity: Juiz
 *
 */

public class JuizDto {

	private Long id;
	
	private String nome;
	
	private String email;
	
	private String cpf;
	
	@NotEmpty ( message = "Nome obrigatório.")
	@Length ( min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Email ( message = "Email inválido.")
	@NotEmpty ( message = "Email obrigatório.")
	@Length ( min = 4, max = 200, message = "Email deve conter entre 4 e 200 caracteres.")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@CPF ( message = "CPF inválido.")
	@NotEmpty ( message = "CPF obrigatório.")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "JuizDto [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + "]";
	}
	
}
