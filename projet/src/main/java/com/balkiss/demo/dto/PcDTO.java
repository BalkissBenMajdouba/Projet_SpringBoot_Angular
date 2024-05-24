package com.balkiss.demo.dto;

import com.balkiss.demo.entities.Marque;
import com.balkiss.demo.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PcDTO {
	private Long idPc;
	private String processeurPc;
	private String nomPc;
	private int memoirePc;
	private int diqueDurPc;
	private double prixPc;
	private Marque marque;
	 private User user;
	 private String nomMarque;
	 

	
	public PcDTO(Long idPc, String processeurPc, String nomPc, int memoirePc, int diqueDurPc, double prixPc,
			Marque marque, User user) {
		super();
		this.idPc = idPc;
		this.processeurPc = processeurPc;
		this.nomPc = nomPc;
		this.memoirePc = memoirePc;
		this.diqueDurPc = diqueDurPc;
		this.prixPc = prixPc;
		this.marque = marque;
		this.user = user;
	}

	public Long getIdPc() {
		return idPc;
	}
	public void setIdPc(Long idPc) {
		this.idPc = idPc;
	}
	public String getProcesseurPc() {
		return processeurPc;
	}
	public void setProcesseurPc(String processeurPc) {
		this.processeurPc = processeurPc;
	}
	public String getNomPc() {
		return nomPc;
	}
	public void setNomPc(String nomPc) {
		this.nomPc = nomPc;
	}
	public int getMemoirePc() {
		return memoirePc;
	}
	public void setMemoirePc(int memoirePc) {
		this.memoirePc = memoirePc;
	}
	public int getDiqueDurPc() {
		return diqueDurPc;
	}
	public void setDiqueDurPc(int diqueDurPc) {
		this.diqueDurPc = diqueDurPc;
	}
	public double getPrixPc() {
		return prixPc;
	}
	public void setPrixPc(double prixPc) {
		this.prixPc = prixPc;
	}
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}
	 
}
