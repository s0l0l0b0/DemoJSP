package com.example.demojsp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class RunwaySurface {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RUNWAY_NO", nullable = false)
    Long runwayNo;

    @Column(name = "SURFACE_TYPE", nullable = false)
    String surfaceType;

    @Column(name = "SURFACE_CONDITION", nullable = false)
    String surfaceCondition;

    @OneToOne
    @MapsId
    @JoinColumn(name = "RUNWAY_NO")
    AirportRunway airportRunway;


    public Long getRunwayNo() {
        return runwayNo;
    }

    public void setRunwayNo(Long runwayNo) {
        this.runwayNo = runwayNo;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(String surfaceType) {
        this.surfaceType = surfaceType;
    }

    public String getSurfaceCondition() {
        return surfaceCondition;
    }

    public void setSurfaceCondition(String surfaceCondition) {
        this.surfaceCondition = surfaceCondition;
    }

    public AirportRunway getAirportRunway() {
        return airportRunway;
    }

    public void setAirportRunway(AirportRunway airportRunway) {
        this.airportRunway = airportRunway;
    }

    @Override
    public String toString() {
        return "RunwaySurface [airportRunway=" + airportRunway + ", runwayNo=" + runwayNo + ", surfaceCondition="
                + surfaceCondition + ", surfaceType=" + surfaceType + "]";
    }

    
}
