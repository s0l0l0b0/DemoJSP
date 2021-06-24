package com.example.demojsp.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AIRPORT_ID", nullable = false)
    Long airportId;
    
    @Column(name = "AIRPORT_NAME", nullable = false)
    String airportName;

    @OneToMany(mappedBy = "airport")
    List<AirportRunway> airportRunways;



    public Long getAirportId() {
        return airportId;
    }
    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }
    public String getAirportName() {
        return airportName;
    }
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
    public List<AirportRunway> getAirportRunways() {
        return airportRunways;
    }
    public void setAirportRunways(List<AirportRunway> airportRunways) {
        this.airportRunways = airportRunways;
    }
    
}
