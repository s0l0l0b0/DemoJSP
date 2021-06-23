package com.example.demojsp.repository;

import com.example.demojsp.domain.AirportRunway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRunwayRepository extends JpaRepository<AirportRunway,Long> {
    
}
