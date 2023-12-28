package com.mission42.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Date dateOfBirth;
    private Date dateOfBaptism;
    private String adhar;
    private String mobile;
    private boolean isAlive;

    @OneToMany(targetEntity = Address.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @OneToMany(targetEntity = FeeEntry.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<FeeEntry> entries;
}
