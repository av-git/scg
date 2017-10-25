package br.jus.trt8.scg.service;

import java.util.List;
import java.util.Optional;

import br.jus.trt8.scg.model.GECJ;

public interface GecjService {
	
	/**
	 * Retorna um Magistrado dado um CPF
	 * 
	 * @param ano
	 * @param mes
	 * @return Option {@link GECJ}
	 */
	Optional<GECJ> obterPor(Long idJuiz, int ano, int mes);
	
	/**
	 * Cadastra um {@link GECJ} na base dados
	 * 
	 * @param gecj
	 * @return {@link GECJ}
	 */
	GECJ salvar(GECJ gecj);
	
	Optional<List<GECJ>> obterPor(Long idJuiz);
}
