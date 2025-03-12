package com.airsofka.authentication.domain.user;

import com.airsofka.authentication.domain.user.events.RegisteredGoogleUser;
import com.airsofka.authentication.domain.user.events.RegisteredUser;
import com.airsofka.authentication.domain.user.values.DocumentID;
import com.airsofka.authentication.domain.user.values.Email;
import com.airsofka.authentication.domain.user.values.IsFrequent;
import com.airsofka.authentication.domain.user.values.MethodAuthentication;
import com.airsofka.authentication.domain.user.values.Nacionality;
import com.airsofka.authentication.domain.user.values.Name;
import com.airsofka.authentication.domain.user.values.Password;
import com.airsofka.authentication.domain.user.values.PhoneNumber;
import com.airsofka.authentication.domain.user.values.Role;
import com.airsofka.authentication.domain.user.values.RoleEnum;
import com.airsofka.authentication.domain.user.values.UserId;
import com.airsofka.shared.domain.generic.AggregateRoot;

import java.sql.SQLOutput;

public class User extends AggregateRoot<UserId> {
  private Name fullName;
  private Email email;
  private Password password;
  private DocumentID documentID;
  private PhoneNumber phoneNumber;
  private Nacionality nacionality;
  private IsFrequent isFrequent;
  private Role role;
  private MethodAuthentication methodAuthentication;

  // region Constructors
  public User() {
    super(new UserId());
    role = Role.of(RoleEnum.USER.name());
    isFrequent = IsFrequent.of(false);
    subscribe(new UserHandler(this));
  }

  private User(UserId identity) {
    super(identity);
  }
  // endregion

  // region Getters and Setters
  public Name getName() {
    return fullName;
  }

  public void setName(Name name) {
    this.fullName = name;
  }

  public Email getEmail() {
    return email;
  }

  public void setEmail(Email email) {
    this.email = email;
  }

  public Password getPassword() {
    return password;
  }

  public void setPassword(Password password) {
    this.password = password;
  }

  public DocumentID getDocumentID() {
    return documentID;
  }

  public void setDocumentID(DocumentID documentID) {
    this.documentID = documentID;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Nacionality getNacionality() {
    return nacionality;
  }

  public void setNacionality(Nacionality nacionality) {
    this.nacionality = nacionality;
  }

  public IsFrequent getIsFrequent() {
    return isFrequent;
  }

  public void setIsFrequent(IsFrequent isFrequent) {
    this.isFrequent = isFrequent;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public MethodAuthentication getMethodAuthentication() {
    return methodAuthentication;
  }

  public void setMethodAuthentication(MethodAuthentication methodAuthentication) {
    this.methodAuthentication = methodAuthentication;
  }
  // endregion

  // region Domain Actions
  public void registerUser(String name, String email, String password, String documentId, String phoneNumber, String nacionality){
    apply(new RegisteredUser(name, email, password, documentId,phoneNumber, nacionality));
  }

  public void registerGoogleUser(String name, String email){
    apply(new RegisteredGoogleUser(name,email));
  }

  // endregion

  // region Public Methods

  // endregion

}
