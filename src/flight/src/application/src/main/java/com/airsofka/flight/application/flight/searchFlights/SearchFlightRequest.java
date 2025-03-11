package com.airsofka.flight.application.flight.searchFlights;

import com.airsofka.shared.application.Request;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class SearchFlightRequest extends Request {
  @NotNull(message = "Passengers information is required")
  @Valid
  private Passengers passengers;

  @NotBlank(message = "Origin is required")
  private String origin;

  @NotBlank(message = "Destination is required")
  private String destination;

  @NotNull(message = "Dates information is required")
  @Valid
  private Dates dates;

  public SearchFlightRequest(String aggregateId, Passengers passengers, String origin, String destination, Dates dates) {
    super(aggregateId);
    this.passengers = passengers;
    this.origin = origin;
    this.destination = destination;
    this.dates = dates;
  }

  @Getter
  @Setter
  public static class Passengers {
    @NotNull(message = "Number of adults is required")
    private Integer adults;
    private Integer children;
    private Integer infants;

    public Passengers(Integer adults, Integer children, Integer infants) {
      this.adults = adults;
      this.children = children;
      this.infants = infants;
    }

    public Passengers(){
    }
  }

  @Getter
  @Setter
  public static class Dates {
    @NotNull(message = "Departure date is required")
    private LocalDateTime departure;
    @NotNull(message = "Return date is required")
    private LocalDateTime returnDate;

    public Dates(LocalDateTime departure, LocalDateTime returnDate) {
      this.departure = departure;
      this.returnDate = returnDate;
    }

    public Dates(){

    }
  }
}