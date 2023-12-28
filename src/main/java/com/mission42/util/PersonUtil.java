package com.mission42.util;

import com.mission42.dto.PersonDTO;
import com.mission42.model.Address;
import com.mission42.model.Person;

import java.util.HashSet;
import java.util.Set;

public class PersonUtil {
    public static Person getPersonFromPersonDTO(PersonDTO personDto) {
        Address address = Address.builder()
                .type(personDto.getAddressDTO().getType())
                .line1(personDto.getAddressDTO().getLine1())
                .line2(personDto.getAddressDTO().getLine2())
                .village(personDto.getAddressDTO().getVillage())
                .state(personDto.getAddressDTO().getState())
                .pin(personDto.getAddressDTO().getPin())
                .build();
        Set<Address> addresses = new HashSet<>();
        addresses.add(address);

        Person p = Person.builder().firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .fatherName(personDto.getFatherName())
                .dateOfBirth(personDto.getDateOfBirth())
                .dateOfBaptism(personDto.getDateOfBaptism())
                .mobile(personDto.getMobile())
                .adhar(personDto.getAdhar())
                .addresses(addresses)
                .build();
        return p;
    }
}
