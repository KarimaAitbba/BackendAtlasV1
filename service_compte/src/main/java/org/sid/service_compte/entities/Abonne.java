package org.sid.service_compte.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="abonne")
@PrimaryKeyJoinColumn(name = "id")
public class Abonne extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cin;
	private String nom;
	private String prenom;
	private String adress;
	private int numTel;
	private String profession;
   	private  Boolean isActivated;
   	
    @JsonManagedReference
   	@OneToOne
   	@JoinColumn(name="Codecontrat")
	private Contrat contrat;
	
	//Ajouté car un abonnée possede -ieurs comptes
    @JsonIgnore
	@OneToMany(mappedBy="abonne",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Abonne(String cin, String nom, String prenom, String adress, int numTel, String profession,
			Boolean isActivated, Contrat contrat, Collection<Compte> comptes) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.numTel = numTel;
		this.profession = profession;
		this.isActivated = isActivated;
		this.contrat = contrat;
		this.comptes = comptes;
	}

	public Abonne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
