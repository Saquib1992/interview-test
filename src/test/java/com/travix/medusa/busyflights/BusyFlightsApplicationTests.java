package com.travix.medusa.busyflights;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.repository.impl.CrazyAirFlightProvider;
import com.travix.medusa.busyflights.repository.impl.ToughJetFlightProvider;
import com.travix.medusa.busyflights.service.BusyFlightService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusyFlightsApplicationTests {

	@MockBean
	CrazyAirFlightProvider crazyAirFlightProvider;

	@MockBean
	ToughJetFlightProvider toughJetFlightProvider;

	@Autowired
	BusyFlightService busyFlightService;


	@Test
	public void contextLoads() {
	}

	@Test
	public void mergeFligtResultTest() {
		BusyFlightsRequest request = new BusyFlightsRequest();
		prepareDate(request);
		List<BusyFlightsResponse> result = busyFlightService.search(request);
		
		Assert.assertEquals("Total flight response is wrong", 4, result.size());
	}
	
	@Test
	public void lowestPriceFlightFirstTest() {
		BusyFlightsRequest request = new BusyFlightsRequest();
		prepareDate(request);
		List<BusyFlightsResponse> result = busyFlightService.search(request);
		
		Assert.assertEquals("Lowest price flight first", BigDecimal.valueOf(3000.0), result.get(0).getFare());
	}
	
	
	private void prepareDate(BusyFlightsRequest request) {
		Mockito.when(crazyAirFlightProvider.searchFlights(request))
				.thenReturn(Arrays.asList(
						new BusyFlightsResponse("Jet Airways", "CrazyAir", BigDecimal.valueOf(3200.00), "PNQ", "BOM",
								"2019-01-13T02:23:54.303", "2019-01-13T09:45:54.303"),
						new BusyFlightsResponse("Vistara", "CrazyAir", BigDecimal.valueOf(5000.00), "BOM", "DEL",
								"2019-01-13T02:23:54.303", "2019-01-13T09:45:54.303")));

		Mockito.when(toughJetFlightProvider.searchFlights(request))
				.thenReturn(Arrays.asList(
						new BusyFlightsResponse("Jet Airways", "TougJet", BigDecimal.valueOf(3000.00), "PNQ", "BOM",
								"2019-01-13T02:23:54.303", "2019-01-13T09:45:54.303"),
						new BusyFlightsResponse("Vistara", "TougJet", BigDecimal.valueOf(5300.00), "BOM", "DEL",
								"2019-01-13T02:23:54.303", "2019-01-13T09:45:54.303")));

	}
	
	
}
