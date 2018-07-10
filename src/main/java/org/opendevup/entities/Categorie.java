package org.opendevup.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Categorie implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "categorie_seq_gen")
	@SequenceGenerator(name="categorie_seq_gen", sequenceName="categorie_id_seq", initialValue = 1, allocationSize = 1)
	private Long idCategorie;
	private String libelle;
	private double montant;
	private double caution;
	private Date CreateAt;
	private Date UpdateAt;
	private User createBy;
	private User updateBy;
	@OneToMany(mappedBy="categorie", fetch=FetchType.LAZY)
	private Collection<Chambre> chambres;
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String libelle, double montant, double caution, Date createAt, Date updateAt, User createBy,
			User updateBy) {
		super();
		this.libelle = libelle;
		this.montant = montant;
		this.caution = caution;
		CreateAt = createAt;
		UpdateAt = updateAt;
		this.createBy = createBy;
		this.updateBy = updateBy;
	}
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public double getCaution() {
		return caution;
	}
	public void setCaution(double caution) {
		this.caution = caution;
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
	public Collection<Chambre> getChambres() {
		return chambres;
	}
	public void setChambres(Collection<Chambre> chambres) {
		this.chambres = chambres;
	}
	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", libelle=" + libelle + ", montant=" + montant + ", caution="
				+ caution + ", CreateAt=" + CreateAt + ", UpdateAt=" + UpdateAt + ", createBy=" + createBy
				+ ", updateBy=" + updateBy + ", chambres=" + chambres + "]";
	}

	
}
