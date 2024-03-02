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

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = true)
    private Person person;
}
