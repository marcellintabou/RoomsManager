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
public class Immeuble implements Serializable{
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "immeuble_seq_gen")
	@SequenceGenerator(name="immeuble_seq_gen", sequenceName="immeuble_id_seq", initialValue = 1, allocationSize = 1)
	private Long idImmeuble;
	private String libelle;
	private boolean occupe = false;
	@OneToMany(mappedBy="immeuble", fetch=FetchType.LAZY)
	private Collection<Niveau> niveaux;
	private Date createAt;
	private Date updateAt;
	private User createBy;
	private User updateBy;
		
	public Immeuble() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Immeuble(String libelle, boolean occupe, Date createAt, Date updateAt, User createBy, User updateBy) {
		super();
		this.libelle = libelle;
		this.occupe = occupe;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.createBy = createBy;
		this.updateBy = updateBy;
	}

	public Long getIdImmeuble() {
		return idImmeuble;
	}

	public void setIdImmeuble(Long idImmeuble) {
		this.idImmeuble = idImmeuble;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public boolean isOccupe() {
		return occupe;
	}

	public void setOccupe(boolean occupe) {
		this.occupe = occupe;
	}

	public Collection<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(Collection<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
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
		return "Immeuble [idImmeuble=" + idImmeuble + ", libelle=" + libelle + ", occupe=" + occupe + ", niveaux="
				+ niveaux + ", createAt=" + createAt + ", updateAt=" + updateAt + ", createBy=" + createBy
				+ ", updateBy=" + updateBy + "]";
	}

}
