package com.airsofka.authentication.infra.mysql.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSql {

    @Id
    private String id;

    private String name;
    private String password;
    private String email;
    private String documentId;
    private String phoneNumber;
    private String nacionality;
    private String methodAuthentication;
    private String role;
    private Boolean isFrequent;

    public UserSql(String id,String name, String role, Boolean isFrequent, String methodAuthentication) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.isFrequent = isFrequent;
        this.methodAuthentication = methodAuthentication;
    }
}
