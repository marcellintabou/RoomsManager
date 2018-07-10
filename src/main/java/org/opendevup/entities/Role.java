package org.opendevup.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Role implements Serializable{
	
	@Id
	@NotNull
    @Size(min = 0, max = 50)
	private String rolename;
	private String description;

	public Role() {
		super();
	}
	
	public Role(String rolename, String description) {
		super();
		this.rolename = rolename;
		this.description = description;
	}

	public String getRolename() {
		return rolename;
	}
	public void setRole(String rolename) {
		this.rolename = rolename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
