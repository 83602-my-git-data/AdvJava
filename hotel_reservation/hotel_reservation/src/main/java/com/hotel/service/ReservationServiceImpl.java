package com.hotel.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.GuestDao;
import com.hotel.dao.ReservationDao;
import com.hotel.dao.RoomDao;
import com.hotel.dto.ReservationReqDto;
import com.hotel.dto.ReservationResponseDto;
import com.hotel.dto.RoomDto;
import com.hotel.entities.Guest;
import com.hotel.entities.Reservation;
import com.hotel.entities.Room;
import com.hotel.exceptions.CustomException;

import io.swagger.v3.oas.models.responses.ApiResponse;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService
{
	//dependencies
	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired 
	private GuestDao guestDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public ReservationResponseDto newReservation(ReservationReqDto requestDto) 
	{
		System.out.println("in reservations");
		System.out.println(requestDto);
//		Reservation  persistentReservation = ReservationDao.save(reservationDao)
				
		Room room = roomDao.findById(requestDto.getRoomId()).orElseThrow(()-> new CustomException("Invalid id !!"));
		System.out.println(room);
		Guest guest = guestDao.findById(requestDto.getGuestId()).orElseThrow(()-> new CustomException("Invalid id !!"));
		//System.out.println(room);
		System.out.println(guest);
			
		Reservation res = mapper.map(requestDto,Reservation.class);
		
		res.setGuestUser(guest);
		
		res.setSelectedRoom(room);
		room.setAvailability(false);
		Reservation res1 = reservationDao.save(res);
		
		
		//room.setAvailability(false);
		
		return mapper.map(res1,ReservationResponseDto.class);
	}


	@Override
	public String addRoom(RoomDto dto) {
		return "Room is Added "+ roomDao.save(mapper.map(dto, Room.class));
	}


	@Override
	public String addGuest(Guest dto) {
		return "Guest is Added "+ guestDao.save(dto);
	}


	@Override
	public List<Room> getRoom() {
		
		return roomDao.findAll();
	}


	@Override
	public List<Guest> getGuest() {

		return guestDao.findAll();
	}
	
	

}
