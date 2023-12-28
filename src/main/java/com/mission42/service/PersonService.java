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
        long id = personDTO.getId();
        Person person = personRepo.findById(id).orElse(new Person());
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

}
