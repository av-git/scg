package br.jus.trt8.scg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.jus.trt8.scg.model.Vara;


@Transactional (readOnly = true) // define que os metodos dessa interface nao irao precisar de transacao
public interface VaraDAO extends JpaRepository<Vara, Long> {

	Vara findByNome( String nome);
	
}
