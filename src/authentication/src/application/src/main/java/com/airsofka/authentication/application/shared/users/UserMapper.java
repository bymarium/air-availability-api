package com.airsofka.authentication.application.shared.users;

import com.airsofka.authentication.application.registeruser.RegisterUserRequest;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.authentication.domain.user.values.DocumentID;
import com.airsofka.authentication.domain.user.values.Email;
import com.airsofka.authentication.domain.user.values.MethodAuthentication;
import com.airsofka.authentication.domain.user.values.Nacionality;
import com.airsofka.authentication.domain.user.values.Name;
import com.airsofka.authentication.domain.user.values.Password;
import com.airsofka.authentication.domain.user.values.PhoneNumber;

public class UserMapper {

    public static User MapperLocal(RegisterUserRequest userRequest){
        User user = new User();
        user.setName(Name.of(userRequest.getName()));
        user.setEmail(Email.of(userRequest.getEmail()));
        user.setPassword(Password.of(userRequest.getPassword()));
        user.setDocumentID(DocumentID.of(userRequest.getDocumentId()));
        user.setPhoneNumber(PhoneNumber.of(userRequest.getPhoneNumber()));
        user.setNacionality(Nacionality.of(userRequest.getNacionality()));
        user.setMethodAuthentication(MethodAuthentication.of("LOCAL"));
        return user;
    }

    public static User MapperGoogle(RegisterUserRequest userRequest){
        User user = new User();
        user.setName(Name.of(userRequest.getName()));
        user.setEmail(Email.of(userRequest.getEmail()));
        user.setMethodAuthentication(MethodAuthentication.of("GOOGLE"));
        return user;
    }





}
