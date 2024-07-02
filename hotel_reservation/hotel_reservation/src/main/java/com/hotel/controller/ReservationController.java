package com.hotel.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dao.GuestDao;
import com.hotel.dao.RoomDao;
import com.hotel.dto.ReservationReqDto;
import com.hotel.dto.RoomDto;
import com.hotel.entities.Guest;
import com.hotel.entities.Room;
import com.hotel.exceptions.CustomException;
import com.hotel.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController 
{
	//dependency
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private GuestDao guestDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private ModelMapper mapper;
	
	public ReservationController()
	{
		System.out.println("in constructor" + getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> createReservation (@RequestBody ReservationReqDto dto)
	{
		System.out.println("in new reservation"+dto);
		
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.newReservation(dto));
		}catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException("Invalid room id and guest id !!"));
		}
	}
	
	@PostMapping("/addroom")
	public ResponseEntity<?> addRoom (@RequestBody RoomDto dto)
	{
		System.out.println("in new reservation"+dto);
		
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addRoom(dto));
		}catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException("invalid room informations!!"));
		}
	}
	
	@PostMapping("/addguest")
	public ResponseEntity<?> addGuest (@RequestBody Guest dto)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addGuest(dto));
		}catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException("in valid room informations!!"));
		}
	}	
	
	@GetMapping("/getguest")
	public ResponseEntity<?> Guest ()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getGuest());
		}catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException("invalid guest informations!!"));
		}
	}	
	
	@GetMapping("/getroom")
	public ResponseEntity<?> room()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getRoom());
		}catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException("sdfjnsdkj!!"));
		}
	}

}
