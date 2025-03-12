package com.airsofka.authentication.application.shared.users;

public class UserResponse {

    private final String name;
    private final String email;
    private final String documentId;
    private final String phoneNumber;
    private final String nacionality;
    private final String methodAuthentication;
    private final String role;
    private final Boolean isFrequent;


    public UserResponse(String name, String email, String documentId, String phoneNumber, String nacionality, String methodAuthentication, String role, Boolean isFrequent) {
        this.name = name;
        this.email = email;
        this.documentId = documentId;
        this.phoneNumber = phoneNumber;
        this.nacionality = nacionality;
        this.methodAuthentication = methodAuthentication;
        this.role = role;
        this.isFrequent = isFrequent;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNacionality() {
        return nacionality;
    }

    public String getMethodAuthentication() {
        return methodAuthentication;
    }

    public String getRole() {
        return role;
    }

    public Boolean getFrequent() {
        return isFrequent;
    }
}
