package com.balkiss.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marque {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idMarque;
	    private String nomMarque;
	    private String paysMarque;
	    private int anneeCMarque; 
	    @JsonIgnore
	    @OneToMany(mappedBy = "marque")//pour ne pas creer une 3eme table
	    private List<Pc> pcs;
	    
	   
	    
		public Marque( String nomMarque, String paysMarque,List<Pc> pcs,int anneeCMarque) {
			super();
			this.nomMarque = nomMarque;
			this.paysMarque=paysMarque;
			this.pcs = pcs;
			this.anneeCMarque=anneeCMarque;
		}
		
		public Long getIdMarque() {
			return idMarque;
		}

		public void setIdMarque(Long idMarque) {
			this.idMarque = idMarque;
		}

		public String getNomMarque() {
			return nomMarque;
		}

		public void setNomMarque(String nomMarque) {
			this.nomMarque = nomMarque;
		}

		public List<Pc> getPcs() {
			return pcs;
		}

		public void setPcs(List<Pc> pcs) {
			this.pcs = pcs;
		}

		@Override
		public String toString() {
			return "Marque [idMarque=" + idMarque + ", nomMarque=" + nomMarque + ", pcs=" + pcs + "]";
		}

		public String getPaysMarque() {
			return paysMarque;
		}

		public void setPaysMarque(String paysMarque) {
			this.paysMarque = paysMarque;
		}

		public int getAnneeCMarque() {
			return anneeCMarque;
		}

		public void setAnneeCMarque(int anneeCMarque) {
			this.anneeCMarque = anneeCMarque;
		}
	    
	}



