package com.hotel.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Reservation
{
	//Reservation ID, guest id
	// check-in date, check-out date, room ID, total price.
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resvId;
	
	@ManyToOne
	@JoinColumn(name = "guest_id")	
	private Guest guestUser;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room selectedRoom;
	
	@Column
	private LocalDate check_in_date;
	
	@Column
	private LocalDate check_out_date;
	
	@Column
	private double totalPrice;

}