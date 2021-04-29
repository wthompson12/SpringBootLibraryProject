package com.cognixia.jump.springboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name="USER")
@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public enum Role {
		ROLE_PATRON, ROLE_LIBRARIAN
	}
	
	// @Id --> primary key
	// @GeneratedValue --> use to set auto increment for this column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// unique --> unique constraint
	// nullable --> not null constraint
	@Column(unique = true, nullable = false)
	private String username;
	
	// unique --> unique constraint
	// nullable --> not null constraint
	@Column(unique = false, nullable = false)
	private String password;
	
	@Column(name="FIRSTNAME")
	String firstName;
	
	@Column(name="LASTNAME")
	String lastName;
	
	@Column(columnDefinition = "boolean default true")
	private boolean accountFrozen;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name="role")
	private Role role;
	
	public User() {
		this(-1L, "N/A", "N/A", "N/A", "N/A", Role.ROLE_PATRON);
	}

	public User(Long id, String username, String password, String firstName, String lastName, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean isAccountFrozen() {
		return accountFrozen;
	}

	public void setAccountFrozen(boolean accoutnFrozen) {
		this.accountFrozen = accoutnFrozen;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
