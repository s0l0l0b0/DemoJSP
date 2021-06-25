package com.example.demojsp.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.demojsp.domain.Airport;
import com.example.demojsp.domain.AirportRunway;
import com.example.demojsp.domain.RunwaySurface;
import com.example.demojsp.repository.AirportRepository;
import com.example.demojsp.repository.AirportRunwayRepository;
import com.example.demojsp.repository.RunwaySurfaceRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirportRunwayRepository airportRunwayRepository;

    @Autowired
    RunwaySurfaceRepository runwaySurfaceRepository;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
        }

    
    @GetMapping("/airport")
    public ModelAndView airport() {
        List<Airport> findAll = airportRepository.findAll();
        return new ModelAndView("airport")
            .addObject("airports", findAll);
    }


    @GetMapping("/runway")
    public ModelAndView runway(@RequestParam(required=false) Long airportId) {
        Optional<Airport> airportOptional = airportRepository.findById(airportId);
        if(airportOptional.isPresent()) {
            Airport airport = airportOptional.get();
            List<AirportRunway> runways = airport.getAirportRunways();
            return new ModelAndView("runways")
                .addObject("runways", runways)
                .addObject("airport", airport);

        } else {
            return new ModelAndView("runways");
        }
    }


    @GetMapping("/newRunway")
    public ModelAndView newRunway(@RequestParam Long airportId){
        Optional<Airport> airport = airportRepository.findById(airportId);
        return new ModelAndView("newRunway")
            .addObject("airport", airport.get());
    }


    @PostMapping("/newRunway")
    public void postRunway(AirportRunway airportRunway, RunwaySurface runwaySurface) {

        if(Objects.nonNull(runwaySurface) && 
            !runwaySurface.getSurfaceType().isBlank() ||
                !runwaySurface.getSurfaceCondition().isBlank()) {

            runwaySurface.setAirportRunway(airportRunway);
            runwaySurfaceRepository.save(runwaySurface);
        } else {
            airportRunwayRepository.save(airportRunway);
        }

    }


}
