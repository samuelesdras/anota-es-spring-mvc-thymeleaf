package esig.atividades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import esig.atividades.model.Atividade;

@Repository
@Transactional
public interface AtividadeRepository extends CrudRepository<Atividade, Long>{

	@Query("select p from Atividade p where p.status = true ")
	List<Atividade> findByStatus (String status);
	
	@Query("select p from Atividade p where p.status = false")
	List<Atividade> findByStatusinativo (String status);
}
