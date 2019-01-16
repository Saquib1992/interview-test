package com.travix.medusa.busyflights.repository;

import java.util.List;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

/**
 * Standard interface to implement a flight search provider
 * @author Saquib Sayyad
 *
 */
public interface FlightSearchProvider {
	
	public static final int DECIMAL_PLACES = 2;
	
	/**
	 * Searches for flight with given request parameters
	 * @param request
	 * @return List of Flights
	 */
	public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request);

}
