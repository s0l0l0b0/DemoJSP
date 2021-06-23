package com.example.demojsp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AIRPORT_ID", nullable = false)
    Long airportId;
    
    @Column(name = "AIRPORT_NAME", nullable = false)
    String airportName;



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
}
