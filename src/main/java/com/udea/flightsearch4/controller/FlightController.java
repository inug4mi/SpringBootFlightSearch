package com.udea.flightsearch4.controller;


import com.udea.flightsearch4.model.Flight;
import com.udea.flightsearch4.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController{
    @Autowired
    private FlightService flightService;
    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam("startDate") String startDate,
                                      @RequestParam("endDate") String endDate,
                                      @RequestParam(value = "origin", required = false)
                                      String origin,
                                      @RequestParam(value = "destination", required =
                                              false) String destination,

                                      @RequestParam(value = "maxPrice", required =

                                              false) Double maxPrice) {
        return flightService.findFlights(LocalDate.parse(startDate),
                LocalDate.parse(endDate), origin, destination, maxPrice);
    }
}