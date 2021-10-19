package com.flightticket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="booking")
@Getter @Setter @NoArgsConstructor
public class Booking {
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private long bookingId;
	 
	 private String seatType;
	 
	 private Integer numOfSeats;
	 
	 private String mealType;
	 
	 @OneToOne(mappedBy="booking")
	 private Passenger passenger;
	 
	 public Booking( String seatType, String mealType, Integer numOfSeats) {

	        this.seatType = seatType;
	        this.mealType = mealType;
	        this.numOfSeats = numOfSeats;
	}
	
	 @JsonIgnore
	 public Passenger getPassenger() {
		 return passenger;
	 }
}
