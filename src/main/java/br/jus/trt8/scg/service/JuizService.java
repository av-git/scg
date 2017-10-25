package br.jus.trt8.scg.service;

import java.util.Optional;

import br.jus.trt8.scg.model.Juiz;

public interface JuizService {

	Juiz salvar(Juiz juiz);

	Optional<Juiz> obterPor(long idJuiz);

	
	Optional<Juiz> obterPorCpf(String cpf);
	
	
	
}
