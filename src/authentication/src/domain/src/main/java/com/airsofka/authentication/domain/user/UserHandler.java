package com.airsofka.authentication.domain.user;

import com.airsofka.authentication.domain.user.events.RegisteredUser;
import com.airsofka.authentication.domain.user.values.DocumentID;
import com.airsofka.authentication.domain.user.values.Email;
import com.airsofka.authentication.domain.user.values.Nacionality;
import com.airsofka.authentication.domain.user.values.Name;
import com.airsofka.authentication.domain.user.values.Password;
import com.airsofka.authentication.domain.user.values.PhoneNumber;
import com.airsofka.shared.domain.generic.DomainActionsContainer;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class UserHandler extends DomainActionsContainer {

    public UserHandler(User user) {
        addAction(registerUser(user));
    }

    public Consumer<? extends DomainEvent> registerUser(User user){
        return (RegisteredUser event) ->{
            if(event.getMethodAuthentication().equals("LOCAL")){
                user.setName(Name.of(event.getName()));
                user.setEmail(Email.of(event.getEmail()));
                user.setPassword(Password.of(event.getPassword()));
                user.setDocumentID(DocumentID.of(event.getEmail()));
                user.setNacionality(Nacionality.of(event.getNacionality()));
                user.setPhoneNumber(PhoneNumber.of(event.getPhoneNumber()));
            }else{
                user.setName(Name.of(event.getName()));
                user.setEmail(Email.of(event.getEmail()));
            }
        };
    }
}
