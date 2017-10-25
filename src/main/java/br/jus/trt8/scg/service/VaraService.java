package br.jus.trt8.scg.service;

import java.util.Optional;

import br.jus.trt8.scg.model.Vara;

public interface VaraService {

	Vara salvar(Vara vara);

	Optional<Vara> obterPor(long idVara);

	Optional<Vara> obterPorNome(String nome);

	
	
}
