package com.mission42.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class FeeEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date entryDate;
    private Double amount;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Person.class)
    private Person person;
}
