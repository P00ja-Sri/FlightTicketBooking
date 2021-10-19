package com.flightticket.service;

import com.flightticket.model.Airport;
import com.flightticket.model.Flight;
import org.springframework.data.domain.Page;
import java.time.LocalDate;
import java.util.List;

public interface FlightService {
	public Page<Flight> getAllFlightsPaged(int pageNum);
    public List<Flight> getAllFlights();
    public Flight getFlightById(long flightId);
    public Flight saveFlight(Flight flight);
    public boolean deleteFlightById(long flightId);
    public List<Flight> getAllFlightsByAirportAndDepartureTime(Airport depAirport, Airport destAirport, LocalDate depDate);
    public void deleteFlightRoute(String flightNumber);
}
