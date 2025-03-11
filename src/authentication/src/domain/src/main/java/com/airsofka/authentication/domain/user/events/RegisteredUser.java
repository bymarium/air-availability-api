package com.airsofka.authentication.domain.user.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class RegisteredUser  extends DomainEvent {

    private String name;
    private String email;
    private String password;

    private String documentId;
    private String phoneNumber;
    private String nacionality;
    private String methodAuthentication;

    public RegisteredUser(String name, String email, String password, String documentId, String phoneNumber, String nacionality) {
        super(EventsEnum.REGISTERED_USER.name());
        this.name = name;
        this.email = email;
        this.password = password;
        this.documentId = documentId;
        this.phoneNumber = phoneNumber;
        this.nacionality = nacionality;

    }

    public RegisteredUser(String name, String email) {
        super(EventsEnum.REGISTERED_USER.name());
        this.email = email;
        this.methodAuthentication = MethodRegister.GOOGLE.name();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getMethodAuthentication() {
        return methodAuthentication;
    }

    public void setMethodAuthentication(String methodAuthentication) {
        this.methodAuthentication = methodAuthentication;
    }

    enum MethodRegister{
        LOCAL,
        GOOGLE
    }


}
