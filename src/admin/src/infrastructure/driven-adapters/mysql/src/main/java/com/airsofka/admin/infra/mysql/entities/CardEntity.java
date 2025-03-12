package com.airsofka.admin.infra.mysql.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity {

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String holderName;

    @Column(nullable = false)
    private String expirationDate;

    @Column(nullable = false)
    private String countryIssue;
}
