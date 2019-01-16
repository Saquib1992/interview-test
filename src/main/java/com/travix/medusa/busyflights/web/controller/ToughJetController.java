package com.travix.medusa.busyflights.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

/**
 * Mock class to return ToughJet REST response
 * @author Saquib Sayyad
 *
 */
@RestController
public class ToughJetController {
	
	@GetMapping("toughjet/search")
	public List<ToughJetResponse> searchFlights(ToughJetRequest request){
		List<ToughJetResponse> list = new ArrayList<>();
		
		list.add(new ToughJetResponse("Air India", 35400.50, 100.0, 10.0, "BOM", "LHR", "2019-01-13T10:23:54.303Z", "2019-01-13T16:23:54.303Z"));
		list.add(new ToughJetResponse("Jet Airways", 1400.50, 100.0, 12.00, "BOM", "PNQ", "2019-01-13T11:23:54.303Z", "2019-01-13T11:55:54.303Z"));
		list.add(new ToughJetResponse("Vistara", 65400.50, 100.00, 11.00, "DEL", "SFO", "2019-01-13T20:30:54.303Z", "2019-01-14T05:10:54.303Z"));
		list.add(new ToughJetResponse("Indigo", 5400.50, 100.00, 5.00, "PNQ", "DXB", "2019-01-13T02:23:54.303Z", "2019-01-13T09:45:54.303Z"));
		
		return list;
		
	}

}
