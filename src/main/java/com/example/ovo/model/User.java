package com.example.ovo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name = "User")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "fullname", nullable = false, length = 200 )
	@NotNull
	private String fullname;
	
	@Column(name = "username", nullable = false, length = 80)
	@Size(min=5, message="Username should have atleast 5 characters")
	@NotNull
	@UniqueElements
	private String username;
	
	@Column(name = "password", nullable = false, length = 50)
	@Size(min=8, message="Password should have atleast 5 characters")
	@NotNull
	private String password;
	
	@ManyToMany
	@JoinTable(name = "User_Role",
			   joinColumns=@JoinColumn(name = "users_id", referencedColumnName = "id"),
			   inverseJoinColumns=@JoinColumn(name = "id_role", referencedColumnName = "id_role"))
	private List<Role> roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
