package com.travix.medusa.busyflights.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightService;

@RestController
public class BusyFlightsController {
	
	@Autowired
	BusyFlightService busyFlightService;
	
	@GetMapping("/busyflight/search")
	public List<BusyFlightsResponse> searchFlight(@Valid BusyFlightsRequest request){
		return busyFlightService.search(request);
	}
}
