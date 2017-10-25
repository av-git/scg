package br.jus.trt8.scg.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);
	
	public PasswordUtils() {
	}
	
	/**
	 * Transforma uma sequencia de caracter legivel para uma sequencia Hash ilegivel
	 * Utilizando o BCrypt
	 * 
	 * @param senha
	 * @return {@link String}
	 */
	public static String gerarSenhaHash(String senha) {
		if ( senha == null) {
			return senha;
		}
		
		log.info("Gerando uma senha hash com BCrypt");
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		return bCryptPasswordEncoder.encode(senha);
	}
	
	/**
	 * Verifica se a senha e valida
	 * 
	 * @param senha
	 * @param senhaCodificada
	 * @return {@link Boolean}
	 */
	public static boolean isSenhaValida(String senha, String senhaCodificada) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.matches(senha, senhaCodificada);
	}
}
