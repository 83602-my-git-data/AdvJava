package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {
	/*1) Uid (unique identifier for each User)
2) Uname (Cannot be Blank)
3) Email (Cannot be Blank)
4) Password (Cannot be blank, min 6 characters)
5) City (Cannot be Blank)
6) Contact_No (Cannot be blank, min 10 digit)*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Long uid;
	@Column(name = "User_Name" ,nullable = false)
	private String UName;
	private String email;
	private String password;
	private String city;
	@Column(name = "Contact_No")
	private String contactNo;
	

}
