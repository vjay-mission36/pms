package com.mission42.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Date dateOfBirth;
    private Date dateOfBaptism;
    private String adhar;
    private String mobile;
    private AddressDTO addressDTO;
}
