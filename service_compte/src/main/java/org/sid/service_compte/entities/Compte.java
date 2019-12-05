package org.sid.service_compte.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class Compte implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long  idCompte;
		private Date dateCreation;
		private double solde;
		
		@JsonBackReference
		@ManyToOne
		@JoinColumn(name="id_abonnee", nullable=false)//colonne de compte
		private Abonne abonne;
		
		@JsonBackReference
		@OneToOne
		@JoinColumn(name="id_cartebancaire") //pour imposer lenom de la colonne de la table
		private CarteBancaire carteBancaire;
		@JsonBackReference
		@OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
		private List<Operation> operations;

		public Long getIdCompte() {
			return idCompte;
		}

		public void setIdCompte(Long idCompte) {
			this.idCompte = idCompte;
		}

		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}

		public double getSolde() {
			return solde;
		}

		public void setSolde(double solde) {
			this.solde = solde;
		}

		public Abonne getAbonne() {
			return abonne;
		}

		public void setAbonne(Abonne abonne) {
			this.abonne = abonne;
		}

		public CarteBancaire getCarteBancaire() {
			return carteBancaire;
		}

		public void setCarteBancaire(CarteBancaire carteBancaire) {
			this.carteBancaire = carteBancaire;
		}

		public List<Operation> getOperations() {
			return operations;
		}

		public void setOperations(List<Operation> operations) {
			this.operations = operations;
		}

		public Compte(Long idCompte, Date dateCreation, double solde, Abonne abonne, CarteBancaire carteBancaire,
				List<Operation> operations) {
			super();
			this.idCompte = idCompte;
			this.dateCreation = dateCreation;
			this.solde = solde;
			this.abonne = abonne;
			this.carteBancaire = carteBancaire;
			this.operations = operations;
		}

		public Compte() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		

}
