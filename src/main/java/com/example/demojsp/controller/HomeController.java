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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

       
    @GetMapping({"/","/airport"})
    public ModelAndView airport() {
        List<Airport> findAll = airportRepository.findAll();
        return new ModelAndView("airport")
            .addObject("airports", findAll);
    }


    @GetMapping("/runway")
    public ModelAndView runway(@RequestParam Long airportId) {
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
            .addObject("airport", airport.get())
            .addObject("operation", "NEW");
    }


    @PostMapping("/newRunway")
    public ModelAndView postRunway(AirportRunway airportRunway, RunwaySurface runwaySurface) {

        if(Objects.nonNull(runwaySurface) && 
            !runwaySurface.getSurfaceType().isBlank() ||
                !runwaySurface.getSurfaceCondition().isBlank()) {

            runwaySurface.setAirportRunway(airportRunway);
            runwaySurfaceRepository.save(runwaySurface);
        } else {
            airportRunwayRepository.save(airportRunway);
        }

        return new ModelAndView("redirect:/runway?airportId=" + airportRunway.getAirport().getAirportId());
    }

    @GetMapping("/editRunway")
    public ModelAndView editRunway(@RequestParam Long runwayNo){
        Optional<AirportRunway> aOptional = airportRunwayRepository.findById(runwayNo);
        ModelAndView modelAndView = new ModelAndView("newRunway");
        if(aOptional.isPresent()) {
            AirportRunway runway = aOptional.get();
            Airport airport = runway.getAirport();
            modelAndView.addObject("runway", runway);
            modelAndView.addObject("airport", airport);
            RunwaySurface runwaySurface = runway.getRunwaySurface();
            if(Objects.nonNull(runwaySurface)) {
                modelAndView.addObject("runwaySurface", runwaySurface);
            }
        }

        modelAndView.addObject("operation", "EDIT");
        return modelAndView;
    }

    @GetMapping("/deleteRunway")
    public ModelAndView deleteRunway(@RequestParam Long runwayNo) {
        Optional<AirportRunway> findById = airportRunwayRepository.findById(runwayNo);
        if (findById.isPresent()) {
            AirportRunway airportRunway = findById.get();
            Airport airport = airportRunway.getAirport();
            airportRunwayRepository.deleteById(runwayNo);
            return new ModelAndView("redirect:/runway?airportId=" + airport.getAirportId());
        }
        return new ModelAndView("redirect:/");  
    }


    @GetMapping("/newAirport")
    public ModelAndView newAriport(){
        return new ModelAndView("newAirport")
            .addObject("operation", "NEW");
    }

    @PostMapping(value="/newAirport")
    public ModelAndView postNewAirport(Airport airport) {
        airportRepository.save(airport);
        return new ModelAndView("redirect:/airport");
    }


    @GetMapping("/editAirport")
    public ModelAndView editAirport(@RequestParam Long airportId){
        Optional<Airport> aOptional = airportRepository.findById(airportId);
        ModelAndView modelAndView = new ModelAndView("newAirport");
        if(aOptional.isPresent()) {
            modelAndView.addObject("newAirport", aOptional.get());
        }
        modelAndView.addObject("operation", "EDIT");
        return modelAndView;
    }
    

    @GetMapping("/deleteAirport")
    public ModelAndView deleteAirport(@RequestParam Long airportId){
        airportRepository.deleteById(airportId);
        return new ModelAndView("redirect:/airport");

    }
    
    
}
