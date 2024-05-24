package com.balkiss.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balkiss.demo.entities.Marque;
import com.balkiss.demo.repos.MarqueRepository;


@RestController
@RequestMapping("/api/marque")
@CrossOrigin("*")
public class MarqueRESTController {
	@Autowired
	MarqueRepository marqueRepository;

	@GetMapping
	public List<Marque> getAllMarques() {
		return marqueRepository.findAll();
	}

	@GetMapping("/{id}")
	public Marque getMarqueById(@PathVariable("id") Long id) {
		return marqueRepository.findById(id).get();
	}


}
