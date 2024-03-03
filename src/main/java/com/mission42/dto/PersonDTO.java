package com.mission42.dto;

import com.mission42.model.FeeEntry;
import lombok.*;

import java.util.Date;
import java.util.List;

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
    private boolean alive;
    private String adhar;
    private String mobile;
    private AddressDTO addressDTO;
    private List<FeeEntryDTO> entries;
}
