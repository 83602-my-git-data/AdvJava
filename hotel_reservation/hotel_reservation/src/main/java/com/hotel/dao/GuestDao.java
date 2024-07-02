package com.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entities.Guest;

public interface GuestDao extends JpaRepository<Guest , Long>
{
	

}
