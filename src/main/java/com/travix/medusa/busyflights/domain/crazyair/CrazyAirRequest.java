package com.travix.medusa.busyflights.domain.crazyair;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CrazyAirRequest {

	@NotEmpty(message = "Orgin is required")
	@Size(min = 3, max = 3, message = "Origin code must be of 3 letters")
    private String origin;
	@NotEmpty
	@Size(min = 3, max = 3, message = "Destination code must be of 3 letters")
    private String destination;
	@NotEmpty(message = "Departure date is requried")
    private String departureDate;
	@NotEmpty(message = "Return date is requried")
    private String returnDate;
	@NotNull(message = "Passenger count is required")
	@Min(value = 1, message = "Minimum number of passenger allowed is one")
	@Max(value = 4, message = "Maximum number of passengers allowed is four")
    private int passengerCount;
    
	/**
	 * Default Constructor
	 */
    public CrazyAirRequest() {
	}

    /**
	 * @param origin
	 * @param destination
	 * @param departureDate
	 * @param returnDate
	 * @param passengerCount
	 */
	public CrazyAirRequest(String origin, String destination, String departureDate, String returnDate,
			int passengerCount) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.passengerCount = passengerCount;
	}

	public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
