package com.hotel.dto;

import com.hotel.entities.RoomType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomDto {
	private Long roomId;
	private int roomNumber;
	private double price;
	private RoomType type;
	private boolean availability;
}
