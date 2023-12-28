package com.mission42.controller;

import com.mission42.model.FeeEntry;
import com.mission42.model.Person;
import com.mission42.service.PersonService;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Set;

@RestController
@RequestMapping("/person")
public class PersonController {
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        log.debug(" getPerson : pid : {} , Person: {} ", id, person);
        return ResponseEntity.status(HttpStatus.FOUND).body(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        personService.removePerson(id);
        return ResponseEntity.status(HttpStatus.OK).body("Person with id:"+id+" is removed");
    }

    @GetMapping("/entries/{id}")
    public ResponseEntity<Set<FeeEntry>> getFeeEntriesById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(personService.getFeeEntriesByPersonId(id));
    }

}
