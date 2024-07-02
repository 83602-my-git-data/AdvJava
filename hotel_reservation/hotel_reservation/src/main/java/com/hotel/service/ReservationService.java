package com.hotel.service;

import java.util.List;

import com.hotel.dto.ReservationReqDto;
import com.hotel.dto.ReservationResponseDto;
import com.hotel.dto.RoomDto;
import com.hotel.entities.Guest;
import com.hotel.entities.Room;

public interface ReservationService 
{
	ReservationResponseDto newReservation(ReservationReqDto requestDto);

	String addRoom(RoomDto dto);

	String addGuest(Guest dto);

	List<Guest> getGuest();

	List<Room> getRoom();

}
