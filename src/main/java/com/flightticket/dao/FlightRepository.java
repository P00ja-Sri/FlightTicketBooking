package com.flightticket.dao;

import com.flightticket.model.Airport;
import com.flightticket.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	 List<Flight> findAllByDepartureAirportEqualsAndDestinationAirportEqualsAndDepartureDateEquals(Airport depAirport, Airport destAirport, LocalDate depDate);
	 void deleteByFlightNumber(String flightNumber);
}
