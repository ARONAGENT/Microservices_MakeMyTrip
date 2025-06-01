package com.springJourneyMax.flight_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @GetMapping("/hello")
    public String helloFromFlights(){
        return "Hello From Flight Service";
    }
}
