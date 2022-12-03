package com.laundry.myApp.models;

import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
@Getter @Setter @NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "Name must be at least 3 characters long")
	private String name;	
	
	@Email(message = "invalid e-mail")
	private String email;

	private String username;

	@NotEmpty(message = "Your password must be informed")
	@Size(min = 3, message = "Your password must be at least 3 characters long")
	private String password;

	@NotEmpty(message = "The login must be informed")
	@Size(min = 4, message = "Your login must be at least 4 characters long")

	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthDate;

	private boolean enabled;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_role",
			   joinColumns = @JoinColumn(name = "user_id"),
			   //role_id is the foreign key
			   inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();

	public void addRole(Role role) {
		roles.add(role);
	}

}
