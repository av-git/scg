package br.jus.trt8.scg.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.trt8.scg.dao.VaraDAO;
import br.jus.trt8.scg.model.Vara;
import br.jus.trt8.scg.service.VaraService;

@Service
public class VaraServiceImpl implements VaraService {
	
	private static final Logger log = LoggerFactory.getLogger(VaraServiceImpl.class);
	
	@Autowired
	private VaraDAO varaDAO;


	@Override
	public Vara salvar(Vara vara) {
		log.info("Salvando Vara:  {}" , vara);
		return varaDAO.save(vara);
	}


	@Override
	public Optional<Vara> obterPor(long idVara) {
		log.info("Buscando Vara com id {}" , idVara);
		return Optional.ofNullable(varaDAO.findOne(idVara));
	}


	@Override
	public Optional<Vara> obterPorNome(String nome) {
		log.info("Buscando Vara com nome {}" , nome);
		return Optional.ofNullable(varaDAO.findByNome(nome));
	}


}
