package com.flightticket.model;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="flight")
@Getter @Setter @NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long flightId;
    private String flightNumber;
    private String flightName;
    private String departureAirportCode;
    private String arrivalAirportCode;
    
    @ManyToOne
    private Airport departureAirport;
    @ManyToOne
    private Airport destinationAirport;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    private String departureTime;

    private String arrivalTime;

    private double flightCharge;
    
    private String trip;

    @OneToMany(mappedBy = "flight")
    List<Passenger> passenger = new ArrayList<>();
    
    public Flight(long flightId,String flightNumber,String flightName ) {
    	this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.flightName = flightName;
    }
    
    @JsonIgnore
    public Airport getDepartureAirport() {
    	return departureAirport;
    }
    
    @JsonIgnore
    public Airport getDestinationAirport() {
    	return destinationAirport;
    }
    
    @JsonIgnore
    public List<Passenger> getPassenger() {
		return passenger;
    }
}
