package com.airsofka.flight.application.flight.createFlight;

import com.airsofka.shared.application.Request;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CreateFlightRequest extends Request {
    private final String flightNumber;
    private final String flightModel;
    private final String routeId;
    private final Double price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private final Date departureTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private final Date arrivalTime;

    public CreateFlightRequest( String flightNumber,String flightModel, String routeId, Double price, Date departureTime, Date arrivalTime) {
        super(null);
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightModel = flightModel;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getRouteId() {
        return routeId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public Double getPrice() {
        return price;
    }

    public String getFlightModel() {
        return flightModel;
    }
}
