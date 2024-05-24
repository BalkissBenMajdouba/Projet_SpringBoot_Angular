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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	private String nomUser;
	private String emailUser;
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Pc> pcs;


	public User(String nomUser, String emailUser, List<Pc> pcs) {
		super();
		this.nomUser = nomUser;
		this.emailUser = emailUser;
		this.pcs = pcs;
	}


	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public List<Pc> getPcs() {
		return pcs;
	}

	public void setPcs(List<Pc> pcs) {
		this.pcs = pcs;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nomUser=" + nomUser + ", emailUser=" + emailUser + ", pcs=" + pcs + "]";
	}
	
	
}
