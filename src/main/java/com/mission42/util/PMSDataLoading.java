package com.mission42.util;

import com.mission42.model.Address;
import com.mission42.model.FeeEntry;
import com.mission42.model.Person;
import com.mission42.repo.PersonRepo;
import com.mission42.service.FeeEntryService;
import com.mission42.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PMSDataLoading implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(PMSDataLoading.class);

    @Autowired
    private PersonService personService;
    @Autowired
    private FeeEntryService feeEntryService;

    @Autowired
    private PersonRepo personRepo;

    @Override
    public void run(String... args) throws Exception {
        log.debug("PMS Loading is starting.... \n start with Person");
        Person person = Person.builder().firstName("Rick").lastName("Parker").fatherName("Parker Richard").mobile("8331929793").adhar("123456783").dateOfBirth(PMSUtils.getDateFromLocalDate(LocalDate.of(1977, 07, 11))).dateOfBaptism(PMSUtils.getDateFromLocalDate(LocalDate.of(1983, 05, 11))).isAlive(true).build();
        Address address = Address.builder().type("PERM").line1("Laxmi Towers").line1("vijayawada rural").village("Tadepalli").pin("520012").build();
        address.setPerson(person);

        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        person.setAddresses(addresses);

        FeeEntry entry = FeeEntry.builder().amount(10d).entryDate(new Date()).build();
        FeeEntry entry3 = FeeEntry.builder().amount(20d).entryDate(PMSUtils.getDateFromLocalDate(LocalDate.now())).build();
        entry.setPerson(person);
        entry3.setPerson(person);

        List<FeeEntry> feeEntries = new ArrayList<>();
        feeEntries.add(entry);
        feeEntries.add(entry3);
        person.setEntries(feeEntries);

        person = personRepo.save(person);
        log.debug("Person 0 : {}", person);

        Person person1 = Person.builder().firstName("Richard").lastName("Parker").fatherName("John Richard").mobile("9494297254").adhar("9876543212").dateOfBirth(PMSUtils.getDateFromLocalDate(LocalDate.of(1978, 11, 11))).dateOfBaptism(PMSUtils.getDateFromLocalDate(LocalDate.of(1983, 05, 11))).isAlive(true).build();
        Address address1 = Address.builder().type("TEMP").line1("Laxmi Towers").line1("vijayawada rural").village("Tadepalli").pin("520012").build();
        address1.setPerson(person1);

        addresses.clear();   // clear the exisiting entries
        addresses.add(address1);  // add the address
        person1.setAddresses(addresses); // set it to person


        FeeEntry entry1 = FeeEntry.builder().amount(30d).entryDate(PMSUtils.getDateFromLocalDate(LocalDate.now())).build();
        FeeEntry entry2 = FeeEntry.builder().amount(40d).entryDate(PMSUtils.getDateFromLocalDate(LocalDate.now())).build();
        entry1.setPerson(person1); entry2.setPerson(person1); // sertting the bidirectional

        feeEntries.clear();
        feeEntries.add(entry1);
        feeEntries.add(entry2);
        person1.setEntries(feeEntries);

        person1 = personRepo.save(person1);
        log.debug("Person 1 : {}", person1);
    }
}
