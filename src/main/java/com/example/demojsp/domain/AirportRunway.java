package com.example.demojsp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AirportRunway {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RUNWAY_NO", nullable = false)
    Long runwayNo;

    @Column(name = "RUNWAY_LENGTH", nullable = false)
    Double runwayLength;

    @Column(name = "RUNWAY_WIDTH", nullable = false)
    Double runwayWidth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AIRPORT_ID")
    Airport airport;

    public Long getRunwayNo() {
        return runwayNo;
    }

    public void setRunwayNo(Long runwayNo) {
        this.runwayNo = runwayNo;
    }

    public Double getRunwayLength() {
        return runwayLength;
    }

    public void setRunwayLength(Double runwayLength) {
        this.runwayLength = runwayLength;
    }

    public Double getRunwayWidth() {
        return runwayWidth;
    }

    public void setRunwayWidth(Double runwayWidth) {
        this.runwayWidth = runwayWidth;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
