package com.laundry.myApp.models;

import java.util.Date;

import javax.validation.constraints.*;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "Name must be at least 3 characters long")
	private String name;	
	
	@Email(message = "invalid e-mail")
	private String email;
	
	@NotEmpty(message = "Your password must be informed")
	@Size(min = 3, message = "Your password must be at least 3 characters long")
	private String password;
	
	@NotEmpty(message = "The login must be informed")
	@Size(min = 4, message = "Your login must be at least 4 characters long")
	
	private String login;
	
	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthDate;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_role",
			   joinColumns = @JoinColumn(name = "user_id"),
			   //role_id is the foreign key
			   inverseJoinColumns = @JoinColumn(name = "role_id"))
	
	private List<Role> roles;
	
	
	//Getters and setters
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	private boolean ativo;	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
