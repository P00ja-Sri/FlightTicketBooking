package com.flightticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightticket.dao.BookingRepository;
import com.flightticket.model.Booking;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

}
