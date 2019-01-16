package com.travix.medusa.busyflights.sort;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

@Component
public class FlightFareComparator implements Comparator<BusyFlightsResponse> {

	@Override
	public int compare(BusyFlightsResponse in1, BusyFlightsResponse in2) {
		return in1.getFare().compareTo(in2.getFare());
	}

}
