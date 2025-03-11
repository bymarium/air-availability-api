package com.airsofka.authentication.application.registeruser;

public class RegisterUserResponse {

    private String name;
    private String email;
    private String documentId;
    private String phoneNumber;
    private String nacionality;
    private String methodAuthentication;
    private String role;
    private Boolean isFrequent;


    public RegisterUserResponse(String name, String email, String documentId, String phoneNumber, String nacionality, String methodAuthentication, String role, Boolean isFrequent) {
        this.name = name;
        this.email = email;
        this.documentId = documentId;
        this.phoneNumber = phoneNumber;
        this.nacionality = nacionality;
        this.methodAuthentication = methodAuthentication;
        this.role = role;
        this.isFrequent = isFrequent;
    }

    public RegisterUserResponse(String name, String email, String role, String methodAuthentication) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.methodAuthentication = methodAuthentication;
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
