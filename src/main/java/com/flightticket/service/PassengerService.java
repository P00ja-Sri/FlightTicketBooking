package com.flightticket.service;

import com.flightticket.model.Passenger;
import org.springframework.data.domain.Page;
import java.util.List;

public interface PassengerService {
	 public Page<Passenger> getAllPassengersPaged(int pageNum);
	 public List<Passenger> getAllPassengers();
	 public Passenger getPassengerById(Long passengerId);
	 public Passenger savePassenger(Passenger passenger);
	 public void deletePassengerById(Long passengerId);
}
