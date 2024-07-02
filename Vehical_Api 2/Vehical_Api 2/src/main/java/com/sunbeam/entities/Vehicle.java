package com.sunbeam.entities;

import javax.annotation.Generated;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Long id;
	@Column(name = "Vehicle_Name")
	private String vName;
	@Enumerated(EnumType.STRING)
	private Company company;
	@Column(name = "Vehicle_Number")
	private String vNumber;
	@Column(name = "Vehicle_Type")
	private String vType;
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
}
