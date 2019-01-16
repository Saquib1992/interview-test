package com.travix.medusa.busyflights.repository.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.repository.FlightSearchProvider;
import com.travix.medusa.busyflights.rest.RestConnector;
import com.travix.medusa.busyflights.util.DateTimeUtility;
/**
 * CrazyAir flight provider implementation
 * @author Saquib Sayyad
 *
 */
@Component
public class CrazyAirFlightProvider extends RestConnector implements FlightSearchProvider {

	private static final String PROVIDER = "CrazyAir";

	private static final String SEARCH_URL = "http://localhost:8080/crazyair/search?origin={origin}&destination={destination}&departureDate={departureDate}&returnDate={returnDate}&passengerCount={passengerCount}";

	@Override
	public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest input) {

		CrazyAirResponse[] response = this.getForObject(CrazyAirFlightProvider.SEARCH_URL, CrazyAirResponse[].class,
				this.getParameters(input));

		return  Arrays.stream(response).map(resp -> this.transform(resp)).collect(Collectors.toList());

	}

	private BusyFlightsResponse transform(CrazyAirResponse response) {
		String departureDate = DateTimeUtility.fromLocalDateTimeToDateTime(response.getDepartureDate());
		String arrivalDate = DateTimeUtility.fromLocalDateTimeToDateTime(response.getArrivalDate());

		BigDecimal fare = BigDecimal.valueOf(response.getPrice()).setScale(DECIMAL_PLACES, RoundingMode.HALF_EVEN);

		return new BusyFlightsResponse(response.getAirline(), PROVIDER, fare, response.getDepartureAirportCode(),
				response.getDestinationAirportCode(), departureDate, arrivalDate);
	}

	private Object[] getParameters(BusyFlightsRequest input) {

		List<String> out = new ArrayList<String>();

		out.add(input.getOrigin());
		out.add(input.getDestination());
		out.add(String.valueOf(input.getDepartureDate()));
		out.add(String.valueOf(input.getReturnDate()));
		out.add(String.valueOf(input.getNumberOfPassengers()));

		return out.toArray();
	}

}
