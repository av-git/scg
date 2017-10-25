package br.jus.trt8.scg.dao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.jus.trt8.scg.model.Juiz;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test") // ATIVAMOS O PROFILE "application-test.properties" para utilizar H2 em memoria 
public class JuizDaoTest {
	
	private static final Logger log = LoggerFactory.getLogger(JuizDaoTest.class);
	
	@Autowired
	private JuizDAO juizDAO;
	
	private static final String CPF = "21261296249";
	private static final String NOME = "JOSE SARAMAGO";

	@Before
	public void setup() {
	
		Juiz juiz = new Juiz();
		juiz.setNome("JOSE SARAMAGO");
		juiz.setCpf(CPF);
		juiz.setEmail("jose@email.com");
		this.juizDAO.save(juiz);
	
	}
	
	@After
	public void tearDown() {
		this.juizDAO.deleteAll();
	}
	
	@Test
	public void buscarPorNome() {
		Juiz juiz = this.juizDAO.findByNome(NOME);
		System.out.println(juiz);
		assertEquals(NOME, juiz.getNome());
	}
}
