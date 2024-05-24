package com.balkiss.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.balkiss.demo.entities.Marque;
import com.balkiss.demo.entities.Pc;
import com.balkiss.demo.entities.User;
import com.balkiss.demo.repos.PcRepository;

@SpringBootTest
class ProjetApplicationTests {

	@Autowired
	private PcRepository pcRepository;// implementation d'interface

	/*
	 * @Test public void testCreatePc() { Pc pc = new Pc("Intel Core i7",
	 * "Gaming Beast", 16, 512, 1200.00); pcRepository.save(pc); // elle enregiste l
	 * obj dans la bdd
	 * 
	 * Pc pc2 = new Pc("AMD Ryzen 5", "Office Pro", 8, 256, 800.00);
	 * pcRepository.save(pc2); Pc pc3 = new Pc("Intel Core i9", "Developer's Dream",
	 * 32, 1024, 2500.00); pcRepository.save(pc3);
	 * 
	 * }
	 */

	@Test
	public void testFindPc() {
		Pc pc = pcRepository.findById(1L).get();
		System.out.println(pc);
	}

	@Test
	public void testUpdatePc() {
		Pc pc = pcRepository.findById(1L).get();// 1 id L= long
		pc.setPrixPc(2000.0);
		pcRepository.save(pc);
	}

	@Test
	public void testDeletePc() {
		pcRepository.deleteById(8L);
		;
	}

	@Test
	public void testListerTousPcs() {
		List<Pc> pcs = pcRepository.findAll();
		for (Pc pc : pcs) {
			System.out.println(pc);
		}
	}

	@Test
	public void testFindPcByNom() {
		List<Pc> pcs = pcRepository.findByNomPc("Office Pro");
		for (Pc pc : pcs) {
			System.out.println(pc);
		}
	}

	@Test
	public void testFindPcByNomContains() {
		List<Pc> pcs = pcRepository.findByNomPcContains("P");
		for (Pc pc : pcs) {
			System.out.println(pc);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Pc> pcs = pcRepository.findByNomPrix("Gaming Beast", 1000.0);
		for (Pc pc : pcs) {
			System.out.println(pc);
		}
	}

	@Test
	public void testfindByMarque() {
		Marque m = new Marque();
		m.setIdMarque(2L);
		List<Pc> pcs = pcRepository.findByMarque(m);
		for (Pc pc : pcs) {
			System.out.println(pc);
		}
	}

	@Test
	public void testfindByUser() {
		User u = new User();
		u.setIdUser(1L);
		List<Pc> pcs = pcRepository.findByUser(u);
		for (Pc pc : pcs) {
			System.out.println(pc);
		}
	}

	@Test
	public void findByMarqueIdMarque() {
		List<Pc> pcs = pcRepository.findByMarqueIdMarque(1L);
		for (Pc pc : pcs) {
			System.out.println(pc);
		}
	}

	@Test
	public void findByUserIdUser() {
		List<Pc> pcs = pcRepository.findByUserIdUser(3L);
		for (Pc pc : pcs) {
			System.out.println(pc);
		}
	}

	@Test
	public void findByOrderByNomPcAsc() {
		List<Pc> pcs = pcRepository.findByOrderByNomPcAsc();
		for (Pc pc : pcs) {
			System.out.println(pc);
		}
	}
	@Test
	public void testTrierPcsNomsPrix()
	{
	List<Pc> pcs = pcRepository.trierPcsNomsPrix();
	for (Pc pc : pcs)
	{
	System.out.println(pc);
	}
	}

	
}
