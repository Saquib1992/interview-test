package com.travix.medusa.busyflights.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;

/**
 * Mock class to return CrazyJet REST response
 * @author Saquib Sayyad
 *
 */
@RestController
public class CrazyAirController {
	
	@GetMapping("/crazyair/search")
	public List<CrazyAirResponse> searchFlights(CrazyAirRequest request){
		List<CrazyAirResponse> list = new ArrayList<>();
		
		list.add(new CrazyAirResponse("Air India", 30400.50, "E", "BOM", "LHR", "2019-01-13T10:23:54.303", "2019-01-13T16:23:54.303"));
		list.add(new CrazyAirResponse("Jet Airways", 1400.50, "E", "BOM", "PNQ", "2019-01-13T11:23:54.303", "2019-01-13T11:55:54.303"));
		list.add(new CrazyAirResponse("Vistara", 65400.50, "B", "DEL", "SFO", "2019-01-13T20:30:54.303", "2019-01-14T05:10:54.303"));
		list.add(new CrazyAirResponse("Indigo", 5400.50, "E", "PNQ", "DXB", "2019-01-13T02:23:54.303", "2019-01-13T09:45:54.303"));
		return list;
	}

}
