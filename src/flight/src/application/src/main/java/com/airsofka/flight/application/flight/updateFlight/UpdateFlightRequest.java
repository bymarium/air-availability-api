package com.airsofka.flight.application.flight.updateFlight;

import com.airsofka.shared.application.Request;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UpdateFlightRequest extends Request {
    private final String flightNumber;
    private final String routeId;
    private final String flightModel;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private final Date departureTime;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private final Date arrivalTime;
    private final Double price;

    public UpdateFlightRequest(String aggregateId, String flightNumber, String routeId, String flightModel, Date departureTime, Date arrivalTime, Double price) {
        super(aggregateId);
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.flightModel = flightModel;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public String getRouteId() {
        return routeId;
    }

    public String getFlightModel() {
        return flightModel;
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
}
