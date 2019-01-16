package com.travix.medusa.busyflights.domain.toughjet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ToughJetResponse {

	@NotEmpty
    private String carrier;
	@NotNull
    private double basePrice;
	@NotNull
    private double tax;
	@NotNull
    private double discount;
	@NotEmpty
	@Size(min = 3, max = 3)
    private String departureAirportName;
	@NotEmpty
	@Size(min = 3, max = 3)
    private String arrivalAirportName;
	@NotEmpty
    private String outboundDateTime;
	@NotEmpty
    private String inboundDateTime;
    
    /**
     * Default Constructor
     */
    public ToughJetResponse() {
	}

    /**
	 * @param carrier
	 * @param basePrice
	 * @param tax
	 * @param discount
	 * @param departureAirportName
	 * @param arrivalAirportName
	 * @param outboundDateTime
	 * @param inboundDateTime
	 */
	public ToughJetResponse(String carrier, double basePrice, double tax, double discount, String departureAirportName,
			String arrivalAirportName, String outboundDateTime, String inboundDateTime) {
		super();
		this.carrier = carrier;
		this.basePrice = basePrice;
		this.tax = tax;
		this.discount = discount;
		this.departureAirportName = departureAirportName;
		this.arrivalAirportName = arrivalAirportName;
		this.outboundDateTime = outboundDateTime;
		this.inboundDateTime = inboundDateTime;
	}

	public String getCarrier() {
        return carrier;
    }

    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(final double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(final double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(final String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(final String outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public String getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(final String inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }
}
