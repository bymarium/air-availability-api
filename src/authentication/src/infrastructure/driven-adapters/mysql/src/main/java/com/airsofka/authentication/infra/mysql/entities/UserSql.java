package com.airsofka.authentication.infra.mysql.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
public class UserSql {

    @Id
    private String id;

    private String name;
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private String documentId;
    private String phoneNumber;
    private String nacionality;
    private String methodAuthentication;
    private String role;
    private String state;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean isFrequent;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean isAuthenticated;


    public UserSql() {
        this.id = UUID.randomUUID().toString();
        this.isFrequent=false;
        this.isAuthenticated=false;
    }

    public UserSql(String id){
        this.id = id;
        this.isFrequent=false;
        this.isAuthenticated=false;
    }
}
