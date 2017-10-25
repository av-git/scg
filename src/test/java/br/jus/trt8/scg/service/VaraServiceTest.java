package br.jus.trt8.scg.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.jus.trt8.scg.dao.VaraDAO;
import br.jus.trt8.scg.model.Vara;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test") // ATIVAMOS O PROFILE "application-test.properties" para utilizar H2 em memoria 
public class VaraServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(VaraServiceTest.class);
	
	/* Estou 'mockando' uma vez que o mesmo ja foi testado no pacote DAO */
	@MockBean
	private VaraDAO varaDAO;
	
	@Autowired
	private VaraService varaService;
	
	@Before
	public void setup() throws Exception {
		/* Criando mocks para simular como a inteface GecjDAO deveria trabalhar */
		//MOCK no metodo this.gecjDAO.obterPor(idJuiz, mes, ano) da interface gecjDAO
		BDDMockito.given(this.varaDAO.findOne(Mockito.anyLong())).willReturn(new Vara());
		
		//MOCK no metodo this.juizDAO.save(Juiz) da interface juizDAO
		BDDMockito.given(this.varaDAO.save(Mockito.any(Vara.class))).willReturn(new Vara());
	}	
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testeBuscarGecjPorIdJuiz() {
		Optional<Vara> vara = this.varaService.obterPor(1);
		
		assertTrue(vara.isPresent());
	}
	
	@Test
	public void buscarGecjPorIdJuizMesAno() {
		Vara vara = this.varaService.salvar(new Vara());
		
		assertNotNull(vara);
	}
}
