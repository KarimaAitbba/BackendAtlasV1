package org.sid.service_compte.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Operation implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long Idperation;
		private Date dateoperation;
		private double montant;
		
		@JsonManagedReference
		@ManyToOne
		@JoinColumn(name="id_compte", nullable=false)//colonne de compte
		private Compte compte;

		public Long getIdperation() {
			return Idperation;
		}

		public void setIdperation(Long idperation) {
			Idperation = idperation;
		}

		public Date getDateoperation() {
			return dateoperation;
		}

		public void setDateoperation(Date dateoperation) {
			this.dateoperation = dateoperation;
		}

		public double getMontant() {
			return montant;
		}

		public void setMontant(double montant) {
			this.montant = montant;
		}

		public Compte getCompte() {
			return compte;
		}

		public void setCompte(Compte compte) {
			this.compte = compte;
		}

		public Operation(Long idperation, Date dateoperation, double montant, Compte compte) {
			super();
			Idperation = idperation;
			this.dateoperation = dateoperation;
			this.montant = montant;
			this.compte = compte;
		}

		public Operation() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
