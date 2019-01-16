package com.travix.medusa.busyflights.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.repository.FlightSearchProvider;
import com.travix.medusa.busyflights.service.BusyFlightService;
import com.travix.medusa.busyflights.sort.FlightFareComparator;

@Component
public class BusyFlightServiceImpl implements BusyFlightService {

	@Autowired
	List<FlightSearchProvider> flightSearchProviders;
	
	@Autowired
	FlightFareComparator fareComparator;

	@Override
	public List<BusyFlightsResponse> search(BusyFlightsRequest request) {
		
		List<CompletableFuture<List<BusyFlightsResponse>>> futures = this.flightSearchProviders.stream()
				.map(searcher -> this.createFutureCompletable(searcher, request)).collect(Collectors.toList());
		
		
		List<BusyFlightsResponse> result = futures.stream()
				.map(CompletableFuture::join)
				.flatMap(response -> response.stream())
				.sorted(fareComparator)
				.collect(Collectors.toList());
		return result;
	}

	private CompletableFuture<List<BusyFlightsResponse>> createFutureCompletable(FlightSearchProvider provider,
			BusyFlightsRequest request) {
		Supplier<List<BusyFlightsResponse>> supplier = () -> {
			return provider.searchFlights(request);
		};
		return CompletableFuture.supplyAsync(supplier);
	}

}
