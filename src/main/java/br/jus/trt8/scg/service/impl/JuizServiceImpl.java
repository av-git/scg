package br.jus.trt8.scg.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.jus.trt8.scg.dao.JuizDAO;
import br.jus.trt8.scg.model.Juiz;
import br.jus.trt8.scg.service.JuizService;

@Service
public class JuizServiceImpl implements JuizService {
	
	private static final Logger log = LoggerFactory.getLogger(JuizServiceImpl.class);
	
	@Autowired
	private JuizDAO juizDAO;

	
	@CachePut // como estamos utilizando o ehCache e caso alguem atualize um dado, devemos informar que o ehCache deve ser atualizado
	@Override
	public Juiz salvar(Juiz juiz) {
		log.info("Salvando Juiz:  {}" , juiz);
		return juizDAO.save(juiz);
	}


	@Override
	public Optional<Juiz> obterPor(long idJuiz) {
		log.info("Buscando Gecj para o idJuiz {}" , idJuiz);
		return Optional.ofNullable(juizDAO.findOne(idJuiz));
	}

	@Cacheable("juizPorCpf") // utilizando o recurso do ehCache definido no arquivo ehcache.xml
	@Override
	public Optional<Juiz> obterPorCpf(String cpf) {
		log.info("Buscando Juiz com CPF {}" , cpf);
		return Optional.ofNullable(juizDAO.findByCpf(cpf));
	}


}
