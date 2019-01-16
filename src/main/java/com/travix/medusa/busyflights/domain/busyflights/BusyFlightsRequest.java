package com.travix.medusa.busyflights.domain.busyflights;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class BusyFlightsRequest {

	@NotEmpty(message = "Orgin is required")
	@Size(min = 3, max = 3, message = "Origin code must be of 3 letters")
    private String origin;
	@NotEmpty
	@Size(min = 3, max = 3, message = "Destination code must be of 3 letters")
    private String destination;
	@NotNull(message = "Departure date is requried")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate departureDate;
	@NotNull(message = "Return date is requried")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate returnDate;
	@NotNull(message = "Number of passengers is required")
	@Min(value = 1, message = "Minimum number of passenger allowed is one")
	@Max(value = 4, message = "Maximum number of passengers allowed is four")
    private int numberOfPassengers;

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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusyFlightsRequest [origin=" + origin + ", destination=" + destination + ", departureDate="
				+ departureDate + ", returnDate=" + returnDate + ", numberOfPassengers=" + numberOfPassengers + "]";
	}
}
