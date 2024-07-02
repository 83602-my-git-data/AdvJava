package com.hotel.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="guestDetails")
@NoArgsConstructor
@Getter
@Setter
@ToString


public class Guest
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guestId;
	
	@Column(length = 20, unique = true)
	private String firstName;
	
	@Column(length = 20)
	private String lastName;
	
	@Column
	private Date dob;


}
