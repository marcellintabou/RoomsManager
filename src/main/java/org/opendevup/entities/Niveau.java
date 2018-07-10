package org.opendevup.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Niveau implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "niveau_seq_gen")
	@SequenceGenerator(name="niveau_seq_gen", sequenceName="niveau_id_seq", initialValue = 1, allocationSize = 1)
	private Long idNiveau;
	private String libelle;
	@OneToMany(mappedBy="niveau", fetch=FetchType.LAZY)
	private Collection<Chambre> chambres;
	
	public Collection<Chambre> getChambres() {
		return chambres;
	}
	public void setChambres(Collection<Chambre> chambres) {
		this.chambres = chambres;
	}
	public Immeuble getImmeuble() {
		return immeuble;
	}
	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}
	@ManyToOne
	@JoinColumn(name="CODE_IMMEUBLE")
	private Immeuble immeuble;
	private Date CreateAt;
	private Date UpdateAt;
	private User createBy;
	private User updateBy;
	public Niveau() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Niveau(String libelle, Date createAt, Date updateAt, User createBy, User updateBy) {
		super();
		this.libelle = libelle;
		CreateAt = createAt;
		UpdateAt = updateAt;
		this.createBy = createBy;
		this.updateBy = updateBy;
	}
	public Long getIdNiveau() {
		return idNiveau;
	}
	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
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
	
	
}
