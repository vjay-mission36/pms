package com.mission42.service;

import com.mission42.dto.PersonDTO;
import com.mission42.model.FeeEntry;
import com.mission42.model.Person;
import com.mission42.repo.PersonRepo;
import com.mission42.util.PersonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    private PersonRepo personRepo;


    public Person getPersonById(final Long id) {
        Optional<Person> personOption = personRepo.findById(id);
        log.debug(" getPersonById : {}  Person : {} ", id, personOption.get());
        return personOption.orElseGet(Person::new);
    }

    public Person savePerson(PersonDTO personDto) {
        Person p = PersonUtil.getPersonFromPersonDTO(personDto);
        return personRepo.save(p);
    }

    public void removePerson(long id) {
        personRepo.deleteById(id);
    }

    public void updatePerson(PersonDTO personDTO) {

        Person person = personRepo.findById(1l).orElse(new Person());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setFatherName(personDTO.getFatherName());
        person.setAdhar(personDTO.getAdhar());
        person.setMobile(personDTO.getMobile());
        personRepo.save(person);
    }

    public Set<FeeEntry> getFeeEntriesByPersonId(Long id) {
        Optional<Person> personOption = personRepo.findById(id);
        return personRepo.findById(id).orElseThrow().getEntries();
    }
/*
    public Person createPerson(PersonDTO p) {
        Person person = Person.builder().firstName(p.getFirstName()).lastName(p.getLastName())
                .fatherName(p.getFatherName()).adhar(p.getAdhar()).mobile(p.getMobile())
                .dateOfBirth(p.getDateOfBirth()).dateOfBaptism(p.getDateOfBaptism())
                .isAlive(p.isAlive())
                .build();
        final Set<FeeEntry> feeEntries = p.getFeeEntryDTOS().stream().map(fe -> FeeEntry.builder().amount(fe.getAmount()).entryDate(fe.getEntryDate()).build()).collect(Collectors.toSet());
        person.setEntries(feeEntries);
        return personRepo.save(person);
    }

 */
}
