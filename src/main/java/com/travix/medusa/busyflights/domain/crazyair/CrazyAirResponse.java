package com.travix.medusa.busyflights.domain.crazyair;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CrazyAirResponse {

	@NotEmpty
    private String airline;
	@NotNull
    private double price;
	@NotEmpty
    private String cabinclass;
	@NotEmpty
	@Size(min = 3, max = 3)
    private String departureAirportCode;
	@NotEmpty
	@Size(min = 3, max = 3)
    private String destinationAirportCode;
	@NotEmpty
    private String departureDate;
	@NotEmpty
    private String arrivalDate;
    
    
    public CrazyAirResponse() {
	}

    /**
	 * @param airline
	 * @param price
	 * @param cabinclass
	 * @param departureAirportCode
	 * @param destinationAirportCode
	 * @param departureDate
	 * @param arrivalDate
	 */
	public CrazyAirResponse(String airline, double price, String cabinclass, String departureAirportCode,
			String destinationAirportCode, String departureDate, String arrivalDate) {
		super();
		this.airline = airline;
		this.price = price;
		this.cabinclass = cabinclass;
		this.departureAirportCode = departureAirportCode;
		this.destinationAirportCode = destinationAirportCode;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

	public String getAirline() {
        return airline;
    }

    public void setAirline(final String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(final String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(final String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(final String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(final String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
