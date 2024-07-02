package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
	@Column(name = "first_name", length = 25) 
	private String firstName;
	@Column(name = "last_name", length = 25) 
	private String lastName;
	@Column(length = 20, unique = true) 
	private String email;
	@Column(length = 25, nullable = false) 
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Role role;
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ "Role="+role+"]";
	}
}
