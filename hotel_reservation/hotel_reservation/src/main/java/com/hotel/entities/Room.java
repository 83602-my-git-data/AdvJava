
//Room: Room ID, room number, type (single, double, suite), price, availability ( Boolean )

package com.hotel.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="roomDetails")
@NoArgsConstructor
@Getter
@Setter
public class Room 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomId;
	
	@Column(length = 20 , unique = true ,nullable = false)
	private int roomNumber;
	
	@Column(length = 20, nullable = false)
	private double price;
	
	@Enumerated(EnumType.STRING)
	@Column
	private RoomType type;
	
	@Column
	private boolean availability;

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", price=" + price + ", type=" + type
				+ ", availability=" + availability + "]";
	}
	
	
}
