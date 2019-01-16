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
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.repository.FlightSearchProvider;
import com.travix.medusa.busyflights.rest.RestConnector;
import com.travix.medusa.busyflights.util.DateTimeUtility;


/**
 * ToughJet flight provider implementation
 * @author Saquib Sayyad
 *
 */

@Component
public class ToughJetFlightProvider extends RestConnector implements FlightSearchProvider {

	private static final String PROVIDER = "ToughJet";

	private static final String SEARCH_URL = "http://localhost:8080/toughjet/search?from={from}&to={to}&outboundDate={outboundDate}&inboundDate={inboundDate}&numberOfAdults={numberOfAdults}";

	@Override
	public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest input) {

		ToughJetResponse[] response = this.getForObject(ToughJetFlightProvider.SEARCH_URL, ToughJetResponse[].class,
				this.getParameters(input));

		return Arrays.stream(response).map(resp -> this.transform(resp)).collect(Collectors.toList());

	}

	private BusyFlightsResponse transform(ToughJetResponse response) {
		String departureDate = DateTimeUtility.fromInstantToDateTime(response.getOutboundDateTime());
		String arrivalDate = DateTimeUtility.fromInstantToDateTime(response.getInboundDateTime());

		double finalPrice = response.getBasePrice() - (response.getBasePrice() * response.getDiscount() / 100)	+ response.getTax();
		BigDecimal fare = BigDecimal.valueOf(finalPrice).setScale(FlightSearchProvider.DECIMAL_PLACES, RoundingMode.HALF_EVEN);

		return new BusyFlightsResponse(response.getCarrier(), ToughJetFlightProvider.PROVIDER, fare,
				response.getDepartureAirportName(), response.getArrivalAirportName(), departureDate, arrivalDate);
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
