package com.mission42.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // latter can be converted enum would be better choice
    private String line1;
    private String line2;
    private String village;
    private String state;
    private String pin;
    @ManyToOne
    @JoinColumn(nullable = true, name = "person_id")
    private Person person;
}

