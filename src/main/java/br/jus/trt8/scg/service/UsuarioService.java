package br.jus.trt8.scg.service;


import java.util.Optional;

import br.jus.trt8.scg.model.Usuario;


public interface UsuarioService {

	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> buscarPorEmail(String email);

}
