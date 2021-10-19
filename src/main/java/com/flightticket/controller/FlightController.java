package com.flightticket.controller;

import com.flightticket.model.Booking;
import com.flightticket.model.Flight;
import com.flightticket.service.AirportService;
import com.flightticket.service.BookingService;
import com.flightticket.service.FlightService;
import com.flightticket.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1.0/flight")
public class FlightController {
	
	@Autowired
    AirportService airportService;
    @Autowired
    FlightService flightService;
    @Autowired
    PassengerService passengerService;
    @Autowired
    BookingService bookingService;
    
    @PostMapping("/stockflight/add/")
    public Flight saveFlight(@Valid @RequestBody Flight flight) {
    	return flightService.saveFlight(flight);
    }
    
    @GetMapping("/airline/info/allfights")
    public List<Flight> getAllFlights() {
    	return flightService.getAllFlights();
    }
    
    @GetMapping("/airline/info/{flightId}")
    public Flight getFlightById(@PathVariable long flightId) {
    	return flightService.getFlightById(flightId);
    }
    
    @PostMapping("/booking/register")
    public Booking saveBooking(@Valid @RequestBody Booking booking) {
    	return bookingService.saveBooking(booking);
    }
    
    @DeleteMapping("/airline/delete/{flightNumber}")
    public void deleteFlightRoute(@PathVariable String flightNumber) {
    	flightService.deleteFlightRoute(flightNumber);
    }
}
