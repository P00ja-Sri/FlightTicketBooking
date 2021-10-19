package com.flightticket.service;


import com.flightticket.model.Airport;
import org.springframework.data.domain.Page;
import java.util.List;

public interface AirportService {
	  public Page<Airport> getAllAirportsPaged(int pageNum);
	  public List<Airport> getAllAirports();
	  public Airport getAirportById(Integer airportId);
	  public Airport saveAirport(Airport airport);
	  public void deleteAirport(Integer airportId);
}
