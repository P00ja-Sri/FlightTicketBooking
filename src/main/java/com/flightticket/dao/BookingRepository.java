package com.flightticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flightticket.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
