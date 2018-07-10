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
public class Chambre implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "chambre_seq_gen")
	@SequenceGenerator(name="chambre_seq_gen", sequenceName="chambre_id_seq", initialValue = 1, allocationSize = 1)
	private Long idChambre;
	private String libelle;
	
	private Date CreateAt;
	private Date UpdateAt;
	private User createBy;
	private User updateBy;
	@ManyToOne
	@JoinColumn(name="CODE_CATEGORIE")
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name="CODE_NIVEAU")
	private Niveau niveau;
	
	public Chambre() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Chambre(String libelle, Date createAt, Date updateAt, User createBy, User updateBy, Categorie categorie,
			Niveau niveau) {
		super();
		this.libelle = libelle;
		CreateAt = createAt;
		UpdateAt = updateAt;
		this.createBy = createBy;
		this.updateBy = updateBy;
		this.categorie = categorie;
		this.niveau = niveau;
	}



	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(Long idChambre) {
		this.idChambre = idChambre;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
		return "Chambre [idChambre=" + idChambre + ", libelle=" + libelle + ", CreateAt=" + CreateAt + ", UpdateAt="
				+ UpdateAt + ", createBy=" + createBy + ", updateBy=" + updateBy + ", categorie=" + categorie
				+ ", niveau=" + niveau + "]";
	}
		
}
