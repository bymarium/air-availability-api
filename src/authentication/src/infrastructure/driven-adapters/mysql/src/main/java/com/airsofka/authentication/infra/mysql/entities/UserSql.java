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
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean isFrequent;


    public UserSql() {
        this.id = UUID.randomUUID().toString();
        this.role="USER";
        this.isFrequent=false;
    }
}
