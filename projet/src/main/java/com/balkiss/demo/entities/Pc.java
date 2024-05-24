package com.balkiss.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPc;
	private String processeurPc;
	private String nomPc;
	private int memoirePc;
	private int diqueDurPc;
	private double prixPc;
	
	 @ManyToOne
	    @JoinColumn(name = "marque_id")
	    private Marque marque;
	 
	 @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	
	public Pc() {
		super();
		}

	public Pc(String processeurPc, String nomPc, int memoirePc, int diqueDurPc, double prixPc) {
		super();
		this.processeurPc = processeurPc;
		this.nomPc = nomPc;
		this.memoirePc = memoirePc;
		this.diqueDurPc = diqueDurPc;
		this.prixPc = prixPc;
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

	@Override
	public String toString() {
		return "Pc [idPc=" + idPc + ", processeurPc=" + processeurPc + ", nomPc=" + nomPc + ", memoirePc=" + memoirePc
				+ ", diqueDurPc=" + diqueDurPc + ", prixPc=" + prixPc + "]";
	}
	
	
	


}
