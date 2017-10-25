package br.jus.trt8.scg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import br.jus.trt8.scg.dao.UsuarioRepository;

@SpringBootApplication
@EnableCaching // habilita o recurso de ehCache na aplicacao
public class ScgApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ScgApplication.class, args);
	}
	
	/* Somente para testes do login com Token depois podemos comentar as linhas abaixo */
	//@Autowired
	//private UsuarioRepository usuarioRepository;
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			/*
			Usuario usuario = new Usuario();
			usuario.setEmail("usuario@email.com");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(PasswordUtils.gerarSenhaHash("123456"));
			this.usuarioRepository.save(usuario);
			
			Usuario admin = new Usuario();
			admin.setEmail("admin@email.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(PasswordUtils.gerarSenhaHash("123456"));
			this.usuarioRepository.save(admin);
			*/
		};
	}
}
