package br.jus.trt8.scg.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.trt8.scg.dao.GecjDAO;
import br.jus.trt8.scg.model.GECJ;
import br.jus.trt8.scg.service.GecjService;

@Service
public class GecjServiceImpl implements GecjService {
	
	private static final Logger log = LoggerFactory.getLogger(GecjServiceImpl.class);
	
	@Autowired
	private GecjDAO gecjDAO;

	@Override
	public Optional<GECJ> obterPor(Long idJuiz, int ano, int mes) {
		log.info("Buscando Gecj para o idJuiz {}, ano {}, mes {}" , idJuiz, ano, mes);
		return Optional.ofNullable(gecjDAO.obterPor(idJuiz, mes, ano));
	}

	@Override
	public GECJ salvar(GECJ gecj) {
		log.info("Salvando Gecj:  {}" , gecj);
		return gecjDAO.save(gecj);
	}

	@Override
	public Optional<List<GECJ>> obterPor(Long idJuiz) {
		log.info("Buscando Gecj para o idJuiz {}" , idJuiz);
		return Optional.ofNullable(gecjDAO.findByJuizId(idJuiz));
	}

	
}
