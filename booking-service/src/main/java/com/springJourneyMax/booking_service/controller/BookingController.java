package com.springJourneyMax.booking_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class BookingController {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;


    @GetMapping("/hi")
    public String hello(){
        return "Hello booking Service";
    }

    @GetMapping("/FetchingFlights")
    public String fromFlightService(){
        ServiceInstance flightService=discoveryClient.getInstances("flight-service").getFirst();
         return restClient.get()
                .uri(flightService.getUri()+"/flights/hello")
                .retrieve()
                .body(String.class);
    }
}
