package com.balkiss.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balkiss.demo.dto.PcDTO;
import com.balkiss.demo.entities.Marque;
import com.balkiss.demo.entities.Pc;
import com.balkiss.demo.entities.User;
import com.balkiss.demo.repos.PcRepository;

@Service
public class PcServiceImpl implements PcService {

	@Autowired
	PcRepository pcRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public PcDTO savePc(PcDTO pcDTO) {
		// TODO Auto-generated method stub
		return convertEntityToDto(pcRepository.save(convertDtoToEntity(pcDTO)));
	}

	@Override
	public PcDTO updatePc(PcDTO pcDTO) {
		// TODO Auto-generated method stub

		return convertEntityToDto(pcRepository.save(convertDtoToEntity(pcDTO)));
	}

	@Override
	public void deletePc(Pc pc) {
		// TODO Auto-generated method stub
		pcRepository.delete(pc);

	}

	@Override
	public void deletePcById(Long id) {
		// TODO Auto-generated method stub
		pcRepository.deleteById(id);

	}

	@Override
	public PcDTO getPc(Long id) {
		// TODO Auto-generated method stub
		return convertEntityToDto(pcRepository.findById(id).get());
	}

	@Override
	public List<PcDTO> getAllPcs() {
		// TODO Auto-generated method stub
		return pcRepository.findAll().stream().map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Pc> findByNomPc(String nom) {
		// TODO Auto-generated method stub
		return pcRepository.findByNomPc(nom);
	}

	@Override
	public List<Pc> findByNomPcContains(String nom) {
		// TODO Auto-generated method stub
		return pcRepository.findByNomPcContains(nom);
	}

	@Override
	public List<Pc> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return pcRepository.findByNomPrix(nom,prix);
	}

	@Override
	public List<Pc> findByMarque(Marque marque) {
		// TODO Auto-generated method stub
		return pcRepository.findByMarque(marque);
	}

	@Override
	public List<Pc> findByUser(User user) {
		// TODO Auto-generated method stub
		return pcRepository.findByUser(user);
	}

	@Override
	public List<Pc> findByMarqueIdMarque(Long id) {
		// TODO Auto-generated method stub
		return pcRepository.findByMarqueIdMarque(id);
	}

	@Override
	public List<Pc> findByUserIdUser(Long id) {
		// TODO Auto-generated method stub
		return pcRepository.findByUserIdUser(id);
	}

	@Override
	public List<Pc> findByOrderByNomPcAsc() {
		// TODO Auto-generated method stub
		return pcRepository.findByOrderByNomPcAsc();

	}

	/*@Override
	public PcDTO convertEntityToDto(Pc pc) {
		PcDTO pcDTO = new PcDTO();
		pcDTO.setIdPc(pc.getIdPc());
		pcDTO.setNomPc(pc.getNomPc());
		pcDTO.setProcesseurPc(pc.getProcesseurPc());
		pcDTO.setMemoirePc(pc.getMemoirePc());
		pcDTO.setDiqueDurPc(pc.getDiqueDurPc());
		pcDTO.setPrixPc(pc.getPrixPc());
		pcDTO.setUser(pc.getUser());
		pcDTO.setMarque(pc.getMarque());
		
		
		return pcDTO;
	}*/

	@Override
	public Pc convertDtoToEntity(PcDTO pcDTO) {
		// TODO Auto-generated method stub
		Pc pc = new Pc();
		pc.setIdPc(pcDTO.getIdPc());
		pc.setNomPc(pcDTO.getNomPc());
		pc.setProcesseurPc(pcDTO.getProcesseurPc());
		pc.setMemoirePc(pcDTO.getMemoirePc());
		pc.setDiqueDurPc(pcDTO.getDiqueDurPc());
		pc.setPrixPc(pcDTO.getPrixPc());
		pc.setUser(pcDTO.getUser());
		pc.setMarque(pcDTO.getMarque());
		 return pc; 
	}
	@Override
	public PcDTO convertEntityToDto(Pc pc) {
		PcDTO pcDTO = modelMapper.map(pc, PcDTO.class);
		 return pcDTO; 
		
	}
	
	
	
}
