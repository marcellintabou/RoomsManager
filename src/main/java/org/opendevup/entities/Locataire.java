package org.opendevup.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Locataire implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "locataire_seq_gen")
	@SequenceGenerator(name="locataire_seq_gen", sequenceName="locataire_id_seq", initialValue = 1, allocationSize = 1)
	private Long idLocataire;
	private String nom;
	private String prenom;
	private String telephone1;
	private String telephone2;
	private String sexe;
	private String email;
	private String numeroPiece;
	private Date dateExpirationPiece;
	private String profession;
	private Date datenaissance;
	private String lieuNaissance;
	
	private Date CreateAt;
	private Date UpdateAt;
	private User createBy;
	private User updateBy;
	
	public Locataire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Locataire(String nom, String prenom, String telephone1, String telephone2, String sexe, String email,
			String numeroPiece, Date dateExpirationPiece, String profession, Date datenaissance, String lieuNaissance,
			Date createAt, Date updateAt, User createBy, User updateBy) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone1 = telephone1;
		this.telephone2 = telephone2;
		this.sexe = sexe;
		this.email = email;
		this.numeroPiece = numeroPiece;
		this.dateExpirationPiece = dateExpirationPiece;
		this.profession = profession;
		this.datenaissance = datenaissance;
		this.lieuNaissance = lieuNaissance;
		CreateAt = createAt;
		UpdateAt = updateAt;
		this.createBy = createBy;
		this.updateBy = updateBy;
	}

	public Long getIdLocataire() {
		return idLocataire;
	}

	public void setIdLocataire(Long idLocataire) {
		this.idLocataire = idLocataire;
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

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroPiece() {
		return numeroPiece;
	}

	public void setNumeroPiece(String numeroPiece) {
		this.numeroPiece = numeroPiece;
	}

	public Date getDateExpirationPiece() {
		return dateExpirationPiece;
	}

	public void setDateExpirationPiece(Date dateExpirationPiece) {
		this.dateExpirationPiece = dateExpirationPiece;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public Date getCreateAt() {
		return CreateAt;
	}

	public void setCreateAt(Date createAt) {
		CreateAt = createAt;
	}

	public Date getUpdateAt() {
		return UpdateAt;
	}

	public void setUpdateAt(Date updateAt) {
		UpdateAt = updateAt;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public String toString() {
		return "Locataire [idLocataire=" + idLocataire + ", nom=" + nom + ", prenom=" + prenom + ", telephone1="
				+ telephone1 + ", telephone2=" + telephone2 + ", sexe=" + sexe + ", email=" + email + ", numeroPiece="
				+ numeroPiece + ", dateExpirationPiece=" + dateExpirationPiece + ", profession=" + profession
				+ ", datenaissance=" + datenaissance + ", lieuNaissance=" + lieuNaissance + ", CreateAt=" + CreateAt
				+ ", UpdateAt=" + UpdateAt + ", createBy=" + createBy + ", updateBy=" + updateBy + "]";
	}




		
}
