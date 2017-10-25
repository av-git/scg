package br.jus.trt8.scg.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {
	
	private static final String SENHA = "123456";
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void testSenhaNulo() throws Exception{
		assertNull(PasswordUtils.gerarSenhaHash(null));
	}
	
	@Test
	public void testGerarSenhaHash() throws Exception {
		String senhaHash = PasswordUtils.gerarSenhaHash(SENHA);
		assertTrue(bCryptPasswordEncoder.matches(SENHA, senhaHash));

	}
	

}
