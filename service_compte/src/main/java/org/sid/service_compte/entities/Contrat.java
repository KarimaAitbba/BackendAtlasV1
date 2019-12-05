package org.sid.service_compte.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
public class Contrat implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		private String  Codecontrat;
		private Date Dateexperation;
		private String objectif;
		
		@JsonBackReference
		@OneToOne(mappedBy="contrat", fetch=FetchType.EAGER)
		@JoinColumn(name="id_abonne")
	    private Abonne abonnee;
		
	   
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="id_bo", nullable=false)//colonne de contrat
		private Bo bo;


		public String getCodecontrat() {
			return Codecontrat;
		}


		public void setCodecontrat(String codecontrat) {
			Codecontrat = codecontrat;
		}


		public Date getDateexperation() {
			return Dateexperation;
		}


		public void setDateexperation(Date dateexperation) {
			Dateexperation = dateexperation;
		}


		public String getObjectif() {
			return objectif;
		}


		public void setObjectif(String objectif) {
			this.objectif = objectif;
		}


		public Abonne getAbonnee() {
			return abonnee;
		}


		public void setAbonnee(Abonne abonnee) {
			this.abonnee = abonnee;
		}


		public Bo getBo() {
			return bo;
		}


		public void setBo(Bo bo) {
			this.bo = bo;
		}


		public Contrat(String codecontrat, Date dateexperation, String objectif, Abonne abonnee, Bo bo) {
			super();
			Codecontrat = codecontrat;
			Dateexperation = dateexperation;
			this.objectif = objectif;
			this.abonnee = abonnee;
			this.bo = bo;
		}


		public Contrat() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
