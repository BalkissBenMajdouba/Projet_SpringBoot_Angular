package com.balkiss.demo.service;

import java.util.List;

import com.balkiss.demo.dto.PcDTO;
import com.balkiss.demo.entities.Marque;
import com.balkiss.demo.entities.Pc;
import com.balkiss.demo.entities.User;

public interface PcService {
	
	PcDTO savePc(PcDTO pcDTO);

	PcDTO updatePc(PcDTO pcDTO);

	void deletePc(Pc pc);

	void deletePcById(Long id);

	PcDTO getPc(Long id);

	List<PcDTO> getAllPcs();

	List<Pc> findByNomPc(String nom);

	List<Pc> findByNomPcContains(String nom);

	List<Pc> findByNomPrix(String nom, Double prix);

	List<Pc> findByMarque(Marque marque);

	List<Pc> findByUser(User user);

	List<Pc> findByMarqueIdMarque(Long id);

	List<Pc> findByUserIdUser(Long id);

	List<Pc> findByOrderByNomPcAsc();
	
	PcDTO convertEntityToDto (Pc pc);
	
	Pc convertDtoToEntity(PcDTO pcDTO);
}
