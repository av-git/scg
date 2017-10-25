package br.jus.trt8.scg.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.trt8.scg.dao.UsuarioRepository;
import br.jus.trt8.scg.model.Usuario;
import br.jus.trt8.scg.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> buscarPorEmail(String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
}
