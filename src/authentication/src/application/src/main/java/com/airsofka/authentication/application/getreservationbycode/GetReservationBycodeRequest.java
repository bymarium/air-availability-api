package com.airsofka.authentication.application.getreservationbycode;

import com.airsofka.shared.application.Request;

public class GetReservationBycodeRequest extends Request {
  private final String code;
  private final String name;

  public GetReservationBycodeRequest(String code, String name) {
    super(null);
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }
}
