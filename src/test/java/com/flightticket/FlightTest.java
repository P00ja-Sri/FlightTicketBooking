package com.flightticket;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightticket.dao.FlightRepository;
import com.flightticket.model.Flight;
import com.flightticket.service.FlightServiceImpl;

@ExtendWith(MockitoExtension.class)
public class FlightTest {
	
	@Mock
	private FlightRepository repository;
	
	@InjectMocks
	private FlightServiceImpl service;
	
	@Test
	void getAllFlights(){
		List<Flight> list = new ArrayList<Flight>(); 
		Flight f1 = new Flight(1,"KLA123","indigo");
		Flight f2 = new Flight(2,"ABU345","QatarAirways");
		list.add(f1);
		list.add(f2);
		
       when(repository.findAll()).thenReturn(list);
		
		List<Flight> fList = service.getAllFlights();
		assertEquals(2,fList.size());	
		
	}
	
	@Test
	void saveFlightTest() {
		Flight f1 = new Flight(1,"MAX123","indigo");
		when(repository.save(f1)).thenReturn(f1);
		Flight savedflight = service.saveFlight(f1);
		assertThat(savedflight).isNotNull();
		assertEquals("indigo",savedflight.getFlightName());
	}
	
	@Test
	public void deleteFlightTest() {
		Flight f1 = new Flight(1,"GE178","indigo");
		repository.deleteById(f1.getFlightId());
		boolean deleteflight = service.deleteFlightById(1);
		assertThat(deleteflight).isNotNull();
		assertEquals(true,deleteflight);
		
	}
	

}