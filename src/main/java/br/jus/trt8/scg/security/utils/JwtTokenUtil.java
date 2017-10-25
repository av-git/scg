package br.jus.trt8.scg.security.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Classe responsal em realizar toda a gestao do token 
 *
 */
@Component
public class JwtTokenUtil {
	
	/* Definicao das chaves */
	static final String CLAIM_KEY_USER_NAME = "sub"; //--> email do usario qu esta autenticando (nome usuario)
	static final String CLAIM_KEY_ROLE = "role";  //--> Perfil de quem esta acesssando (Admin ou Usuario)
	static final String CLAIM_KEY_CREATED = "created"; // definicao de quando foi gerado
	
	/* importando as propriedade do application.properties */
	@Value("${jwt.secret}")
	private String secret;
	
	/* importando as propriedade do application.properties */
	@Value("${jwt.expiration}")
	private Long expiration;
	
	/**
	 * retorna o nome do usario(email) contido no token JWT.
	 * 
	 * @param token
	 * @return {@link String}
	 */
	public String getNomeUsuarioDoToken(String token) {
		
		String username;
		try {
			
			Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
			
		} catch (Exception e) {
			username = null;
			//System.out.println("Log getUsernameFromToken: " +e);
		}
	
		return username;
	}
	
	/**
	 * Retorna a Data de expiracao dado um token JWT
	 * 
	 * @param token
	 * @return
	 */
	public Date getDataExpiracaoDoToken(String token) {
		Date dataExperiracao;
		
		try {
			
			Claims claims = getClaimsFromToken(token);
			dataExperiracao = claims.getExpiration();
			
		} catch (Exception e) {
			dataExperiracao = null;
			System.out.println("Log getDataExpiracaoDoToken: " +e);
		}
		
		return dataExperiracao;
	}
	
	/**
	 * Criar um novo token JWT
	 * @param token
	 * @return
	 */
	public String criarNovoToken(String token) {
		String novoToken;
		
		try {
			Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			novoToken = gerarToken(claims);
		} catch (Exception e) {
			novoToken = null;
			System.out.println("Log criarNovoToken: " +e);
		}
		
		return novoToken;
	}
	
	/**
	 * Verifica se o token e Valido
	 * @param token
	 * 
	 * @return {@link Boolean}
	 */
	public boolean isTokenValido(String token) {
		return !tokenExpirado(token);
	}
	
	/**
	 * Retorna um novo token JWT com base nos dados do usuario
	 * 
	 * @param userDetails
	 * @return {@link String}
	 */
	public String obterToken(UserDetails userDetails) {
		 Map<String, Object> claims = new HashMap<>();
		 claims.put(CLAIM_KEY_USER_NAME, userDetails.getUsername());
		 userDetails.getAuthorities().forEach(perfil -> claims.put(CLAIM_KEY_ROLE, perfil.getAuthority()));
		 claims.put(CLAIM_KEY_CREATED, new Date());
		 
		 return gerarToken(claims);
	}

	
	/**
	 * Realiza o parse do token JWT para obter as informacaoes contidas no corpo
	 * 
	 * @param token
	 * @return Claims
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		
		return claims;
	}
	
	
	/**
	 * Verifica se o token JWT expirou
	 * 
	 * @param token
	 * @return {@link Boolean}
	 */
	private boolean tokenExpirado(String token) {
		Date dataExperiracao = this.getDataExpiracaoDoToken(token);
		
		if (dataExperiracao == null) {
			return false;
		}
		
		return dataExperiracao.before(new Date());
	}
	
	
	/**
	 * Gera um novo token JWT contendo os dados fornecidos
	 * 
	 * @param claims
	 * @return {@link String}
	 */
	private String gerarToken(Map<String, Object> claims) {
		
		return Jwts.builder().setClaims(claims).setExpiration(gerarDataExpiracao())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	/**
	 * Rettorna data expiracao do token com base na data atual
	 * 
	 * @return
	 */
	public Date gerarDataExpiracao() {
		return new Date(System.currentTimeMillis() + expiration * 1000);
	}
}
