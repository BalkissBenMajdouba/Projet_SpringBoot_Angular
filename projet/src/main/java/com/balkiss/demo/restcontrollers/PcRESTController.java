package com.balkiss.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.balkiss.demo.dto.PcDTO;
import com.balkiss.demo.entities.Pc;
import com.balkiss.demo.service.PcService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PcRESTController {

	@Autowired
	PcService pcService;

	@GetMapping
	public List<PcDTO> getAllPcs() {
		return pcService.getAllPcs();
	}

	@GetMapping("/{id}")
	public PcDTO getPcById(@PathVariable("id") Long id) {
		return pcService.getPc(id);
	}

	@PostMapping
	public PcDTO createPc(@RequestBody PcDTO pcDTO) {
		return pcService.savePc(pcDTO);
	}

	@PutMapping
	public PcDTO updatePc(@RequestBody PcDTO pcDTO) {
		return pcService.updatePc(pcDTO);
	}

	@DeleteMapping("/{id}")
	public void deletePc(@PathVariable("id") Long id) {
		pcService.deletePcById(id);
	}

	@GetMapping("/pcMarque/{idMarque}")
	public List<Pc> getPcsByMarqueId(@PathVariable("idMarque") Long idMarque) {
		return pcService.findByMarqueIdMarque(idMarque);
	}
	
	@GetMapping("/pcUser/{idUser}")
	public List<Pc> findByUserIdUser(@PathVariable("idUser") Long idUser) {
		return pcService.findByUserIdUser(idUser);
	}
	@GetMapping("/pcsByName/{nom}")
	public List<Pc> findByNomPcContains(@PathVariable("nom") String nom) {
	return pcService.findByNomPcContains(nom);
	}

}
