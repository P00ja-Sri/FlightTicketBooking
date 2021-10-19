package com.flightticket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="airport")
@Getter @Setter @NoArgsConstructor
public class Airport {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long airportId;
    private String airportCode;
    private String airportName;
    private String city;
    private String state;
    private String country;


    @OneToMany(mappedBy = "departureAirport")
    List<Flight> flights = new ArrayList<>();


    public Airport(String airportCode, String airportName, String city, String state, String country) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.state = state;
        this.country = country;
    }
    
    @JsonIgnore
    public List<Flight> getFlight() {
    	return flights;
    }
    
}