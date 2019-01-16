package com.travix.medusa.busyflights.domain.toughjet;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ToughJetRequest {

	@NotEmpty(message = "From is required")
	@Size(min = 3, max = 3, message = "From code must be of 3 letters")
    private String from;
	@NotEmpty(message = "To is required")
	@Size(min = 3, max = 3, message = "To code must be of 3 letters")
    private String to;
	@NotEmpty(message = "Outbound date is requried")
    private String outboundDate;
	@NotEmpty(message = "Inbound date is requried")
    private String inboundDate;
	@NotNull(message = "Number of adults is required")
	@Min(value = 1, message = "Minimum number of adults allowed is one")
	@Max(value = 4, message = "Maximum number of adults allowed is four")
    private int numberOfAdults;

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
