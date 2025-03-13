package com.airsofka.authentication.application.getalluser;

import com.airsofka.authentication.application.shared.users.UserResponse;
import java.util.List;

public class GetAllUserResponse {
    private final List<UserResponse> userResponses;

    public GetAllUserResponse(List<UserResponse> userResponses) {
        this.userResponses = userResponses;
    }

    public List<UserResponse> getUserResponses() {
        return userResponses;
    }

}
