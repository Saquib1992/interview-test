package com.travix.medusa.busyflights.domain.busyflights;

import java.math.BigDecimal;

public class BusyFlightsResponse {
	
	
	private String airline;
	private String supplier;
	private BigDecimal fare;
	private String departureAirportCode;
	private String destinationAirportCode;
	private String departureDate;
	private String arrivalDate;

	
	/**
	 * Default Constructor
	 */
	public BusyFlightsResponse() {
	}
	
	/**
	 * @param airline
	 * @param supplier
	 * @param fare
	 * @param departureAirportCode
	 * @param destinationAirportCode
	 * @param departureDate
	 * @param arrivalDate
	 */
	public BusyFlightsResponse(String airline, String supplier, BigDecimal fare, String departureAirportCode,
			String destinationAirportCode, String departureDate, String arrivalDate) {
		super();
		this.airline = airline;
		this.supplier = supplier;
		this.fare = fare;
		this.departureAirportCode = departureAirportCode;
		this.destinationAirportCode = destinationAirportCode;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}
	/**
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}
	/**
	 * @param airline the airline to set
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}
	/**
	 * @return the supplier
	 */
	public String getSupplier() {
		return supplier;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	/**
	 * @return the fare
	 */
	public BigDecimal getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(BigDecimal fare) {
		this.fare = fare;
	}
	/**
	 * @return the departureAirportCode
	 */
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}
	/**
	 * @param departureAirportCode the departureAirportCode to set
	 */
	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}
	/**
	 * @return the destinationAirportCode
	 */
	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}
	/**
	 * @param destinationAirportCode the destinationAirportCode to set
	 */
	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}
	/**
	 * @return the departureDate
	 */
	public String getDepartureDate() {
		return departureDate;
	}
	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * @return the arrivalDate
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusyFlightsResponse [airline=" + airline + ", supplier=" + supplier + ", fare=" + fare
				+ ", departureAirportCode=" + departureAirportCode + ", destinationAirportCode="
				+ destinationAirportCode + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + "]";
	}
}
