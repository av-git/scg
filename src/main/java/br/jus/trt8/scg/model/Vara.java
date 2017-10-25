package br.jus.trt8.scg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: Vara
 *
 */
@Entity
public class Vara implements Serializable {

	private static final long serialVersionUID = 8321016001140324826L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VARA_SEQ")
    @SequenceGenerator(sequenceName = "vara_seq", allocationSize = 1, name = "VARA_SEQ")
	private Long id;
	
	private String nome;

	public Vara() {
		super();
	}   
	public String getNome() {
		return this.nome;
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
 }
