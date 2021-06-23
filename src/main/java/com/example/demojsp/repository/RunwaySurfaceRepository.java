package com.example.demojsp.repository;

import com.example.demojsp.domain.RunwaySurface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RunwaySurfaceRepository extends JpaRepository<RunwaySurface, Long>{
    
}
