package com.balkiss.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.balkiss.demo.entities.Marque;
import com.balkiss.demo.entities.Pc;
import com.balkiss.demo.entities.User;
@RepositoryRestResource(path = "rest")
public interface PcRepository extends JpaRepository<Pc, Long> {
	List<Pc> findByNomPc(String nom);
	List<Pc> findByNomPcContains(String nom);
	
	/*@Query("select pc from Pc pc where pc.nomPc like %?1 and pc.prixPc > ?2")//Pc mouch table == entity
	List<Pc> findByNomPrix (String nom, Double prix);*/
	
	@Query("select pc from Pc pc where pc.nomPc like %:nom and pc.prixPc > :prix")
	List<Pc> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select pc from Pc pc where pc.marque = ?1")
	List<Pc> findByMarque (Marque marque);
	
	@Query("select pc from Pc pc where pc.user = ?1")
	List<Pc> findByUser (User user);
	
	List<Pc> findByMarqueIdMarque(Long id);
	List<Pc> findByUserIdUser(Long id);
	List<Pc> findByOrderByNomPcAsc();
	
	@Query("select pc from Pc pc order by pc.nomPc ASC, pc.prixPc DESC")
	List<Pc> trierPcsNomsPrix ();
	
}
 