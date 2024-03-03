package com.mission42.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type; // latter can be converted enum would be better choice
    private String line1;
    private String line2;
    private String village;
    private String state;
    private String pin;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Person.class)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
}

