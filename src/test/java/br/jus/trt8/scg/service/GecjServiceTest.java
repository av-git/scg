package br.jus.trt8.scg.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
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

import br.jus.trt8.scg.dao.GecjDAO;
import br.jus.trt8.scg.model.GECJ;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test") // ATIVAMOS O PROFILE "application-test.properties" para utilizar H2 em memoria 
public class GecjServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(GecjServiceTest.class);
	
	/* Estou 'mockando' uma vez que o mesmo ja foi testado no pacote DAO */
	@MockBean
	private GecjDAO gecjDAO;
	
	@Autowired
	private GecjService gecjService;
	
	@Before
	public void setup() throws Exception {
		/* Criando mocks para simular como a inteface GecjDAO deveria trabalhar */
		//MOCK no metodo this.gecjDAO.obterPor(idJuiz, mes, ano) da interface gecjDAO
		BDDMockito.given(this.gecjDAO.obterPor(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyInt())).willReturn(new GECJ());
		
		//MOCK no metodo this.gecjDAO.save(gecj) da interface gecjDAO
		BDDMockito.given(this.gecjDAO.save(Mockito.any(GECJ.class))).willReturn(new GECJ());
	}	
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testeBuscarGecjPorIdJuiz() {
		long idJuiz = 1;
		Optional<List<GECJ>> gecjDoJuiz = this.gecjService.obterPor(idJuiz);
		
		assertTrue(gecjDoJuiz.isPresent());
	}
	
	@Test
	public void buscarGecjPorIdJuizMesAno() {
		GECJ gecjSalva = this.gecjService.salvar(new GECJ());
		
		assertNotNull(gecjSalva);
	}
}
