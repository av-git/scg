package br.jus.trt8.scg.dao;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.jus.trt8.scg.model.GECJ;


@Transactional (readOnly = true) // define que os metodos dessa interface nao irao precisar de transacao
@NamedQueries({
	@NamedQuery (name = "GecjDAO.findByJuizId",
			query = "SELECT gecj FROM GECJ gecj WHERE gecj.juiz.id = :juizId") })
public interface GecjDAO extends JpaRepository<GECJ, Long>, JpaSpecificationExecutor<GECJ> {
	
	List<GECJ> findByJuizId(@Param("juizId") Long juizId);
	
	Page<GECJ> findByJuizId(@Param("juizId") Long juizId, Pageable paginacao);
	
	/**
	 * 2.3.5 Using named parameters
	 * 
	 * @param juizId
	 * @param mes
	 * @param ano
	 * @return {@link GECJ}
	 */
	@Query("SELECT gecj FROM GECJ gecj "
			+ "WHERE gecj.juiz.id = :juizId "
			+ "and gecj.mes = :mes "
			+ "and gecj.ano = :ano")
	GECJ obterPor (@Param("juizId") Long juizId,
            	   @Param("mes") Integer mes,
				   @Param("ano") Integer ano);

}