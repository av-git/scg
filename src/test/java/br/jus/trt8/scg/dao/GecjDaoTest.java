package br.jus.trt8.scg.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.jus.trt8.scg.model.GECJ;
import br.jus.trt8.scg.model.GecjItem;
import br.jus.trt8.scg.model.Juiz;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test") // ATIVAMOS O PROFILE "application-test.properties" para utilizar H2 em memoria 
public class GecjDaoTest {
	
	private static final Logger log = LoggerFactory.getLogger(GecjDaoTest.class);
	
	@Autowired
	private GecjDAO gecjDAO;
	
	@Autowired
	private JuizDAO juizDAO;
	
	private Juiz juizSalvo;
	
	@Before
	public void setup() {
		
		Juiz juiz = new Juiz();
		juiz.setNome("JOSE SARAMAGO");
		juizSalvo = this.juizDAO.save(juiz);
		
		GECJ gecj = new GECJ();
		gecj.setAno(2017);
		gecj.setAprovado(true);
		gecj.setDataCalculo(new Date());
		gecj.setDeAcordo(true);
		gecj.setJustificativa(null);
		gecj.setMes(10);
		gecj.setParecer(null);
		gecj.setJuiz(juizSalvo);
		
		for (int i = 1; i <= 30; i++) {
			GecjItem dia = new GecjItem();
			dia.setAuxilio("NAO");
			dia.setDeAcordo(true);
			dia.setDeferimento(null);
			dia.setDia(i);
			dia.setEmVaraHabilitada(true);
			dia.setFinalidadeEvento("Titularidade");
			dia.setGratificavel(true);
			dia.setJustificativa(null);
			dia.setMotivo(null);
			dia.setParecer(null);
			dia.setSubTipoEvento("DE");
			dia.setTipoEvento("P");
			dia.setUtil(true);
			dia.setVersao("P");
			
			gecj.adicionarDia(dia);
		}
		
		gecjDAO.save(gecj);
		
		GECJ gecj2 = new GECJ();
		gecj2.setAno(2017);
		gecj2.setAprovado(true);
		gecj2.setDataCalculo(new Date());
		gecj2.setDeAcordo(true);
		gecj2.setJustificativa(null);
		gecj2.setMes(11);
		gecj2.setParecer(null);
		gecj2.setJuiz(juizSalvo);
		
		for (int i = 1; i <= 30; i++) {
			GecjItem dia = new GecjItem();
			dia.setAuxilio("NAO");
			dia.setDeAcordo(true);
			dia.setDeferimento(null);
			dia.setDia(i);
			dia.setEmVaraHabilitada(true);
			dia.setFinalidadeEvento("Titularidade");
			dia.setGratificavel(true);
			dia.setJustificativa(null);
			dia.setMotivo(null);
			dia.setParecer(null);
			dia.setSubTipoEvento("DE");
			dia.setTipoEvento("P");
			dia.setUtil(true);
			dia.setVersao("P");
			
			gecj2.adicionarDia(dia);
		}
		
		gecjDAO.save(gecj2);
	}	
	
	@After
	public void tearDown() {
		this.gecjDAO.deleteAll();
		this.juizDAO.deleteAll();
	}
	
	@Test
	public void testeBuscarGecjPorIdJuiz() {
		List<GECJ> lista = gecjDAO.findByJuizId(juizSalvo.getId());
		assertEquals(juizSalvo.getId(), lista.iterator().next().getJuiz().getId());
	}
	
	@Test
	public void testeBuscarGecjPorIdJuizComPaginacao() {
		PageRequest paginacao = new PageRequest(0, 1);
		Page<GECJ> lista = gecjDAO.findByJuizId(juizSalvo.getId(), paginacao);
		assertEquals(1, lista.getSize());
	}
	
	@Test
	public void buscarGecjPorIdJuizMesAno() {
		GECJ gecj = gecjDAO.obterPor(juizSalvo.getId(), 10, 2017);
		assertNotNull(gecj);
	}
}
