package br.jus.trt8.scg.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.jus.trt8.scg.model.Juiz;
import br.jus.trt8.scg.service.JuizService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test") // ATIVAMOS O PROFILE "application-test.properties" para utilizar H2 em memoria  
public class CadastroJuizControllerTest {
	
	private static final String NOME = "avelino";

	private static final String EMAIL = "avelino@gmail.com";

	private static final Logger log = LoggerFactory.getLogger(CadastroJuizControllerTest.class);
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private JuizService juizService;
	
	private static final Long ID_JUIZ = Long.valueOf(1);
	private static final String CPF = "76724220220";
	private static final String BUSCAR_JUIZ_POR_CPF = "/scg/juiz/cpf/";
	
	public CadastroJuizControllerTest() {
		super();
	}
	
	@Test
	@WithMockUser // SIMULA UM USUARIO LOGADO
	public void testBuscarJuizPorCpfInvalido() throws Exception {
		BDDMockito.given(this.juizService.obterPorCpf(Mockito.anyString())).willReturn(Optional.empty());
		
		log.info("URI: {}", BUSCAR_JUIZ_POR_CPF);
		
		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_JUIZ_POR_CPF + CPF).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.errors").value("Juiz com CPF " + CPF +" não encontrado"));
	}
	
	@Test
	@WithMockUser // SIMULA UM USUARIO LOGADO
	public void testBuscarJuizComCpfValido() throws Exception {
		
		BDDMockito.given(this.juizService.obterPorCpf(Mockito.anyString()))
			.willReturn(Optional.of(this.obterDadosJuiz()));
		
		log.info("URI: {}", BUSCAR_JUIZ_POR_CPF + CPF);
		
		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_JUIZ_POR_CPF + CPF)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				
				.andExpect(jsonPath("$.data.id").value(ID_JUIZ))
				.andExpect(jsonPath("$.data.cpf", equalTo(CPF)))
				.andExpect(jsonPath("$.data.email", equalTo(EMAIL)))
				.andExpect(jsonPath("$.data.nome", equalTo(NOME)))
				
				.andExpect(jsonPath("$.errors").isEmpty());
	}

	private Juiz obterDadosJuiz() {
		
		Juiz juiz = new Juiz();
		juiz.setId(ID_JUIZ);
		juiz.setCpf(CPF);
		juiz.setEmail(EMAIL);
		juiz.setNome(NOME);
		
		return juiz;
	}
}
