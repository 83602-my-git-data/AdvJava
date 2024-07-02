package com.hotel.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReservationReqDto
{
//	private String firstName;
//	private String lastName;
	private LocalDate check_in_date;
	private LocalDate check_out_date;
	private Long roomId;
	private Long guestId;
	

}
