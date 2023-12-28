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
import java.util.HashSet;
import java.util.Set;

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


        Set<Address> addres_set = new HashSet<>();
        addres_set.add(address);
        person.setAddresses(addres_set);

        FeeEntry entry = FeeEntry.builder().amount(10d).entryDate(PMSUtils.getDateFromLocalDate(LocalDate.now())).build();
        FeeEntry entry3 = FeeEntry.builder().amount(100d).entryDate(PMSUtils.getDateFromLocalDate(LocalDate.now())).build();


        person.setEntries(new HashSet<FeeEntry>());
        person.getEntries().add(entry);
        person.getEntries().add(entry3);

        person = personRepo.save(person);
        log.debug("Person 0 : {}", person);

        Person person1 = Person.builder().firstName("Richard").lastName("Parker").fatherName("John Richard").mobile("9494297254").adhar("9876543212")
                .dateOfBirth(PMSUtils.getDateFromLocalDate(LocalDate.of(1978, 11, 11)))
                .dateOfBaptism(PMSUtils.getDateFromLocalDate(LocalDate.of(1983, 05, 11))).isAlive(true).build();
        Address address1 = Address.builder().type("TEMP").line1("Laxmi Towers").line1("vijayawada rural").village("Tadepalli").pin("520012").build();

        Set<Address> addres_set1 = new HashSet<>();
        addres_set1.add(address1);
        person1.setAddresses(addres_set1);

        FeeEntry entry1 = FeeEntry.builder().amount(10d).entryDate(PMSUtils.getDateFromLocalDate(LocalDate.now())).build();
        FeeEntry entry2 = FeeEntry.builder().amount(20d).entryDate(PMSUtils.getDateFromLocalDate(LocalDate.now())).build();

        person1.setEntries(new HashSet<FeeEntry>());
        person1.getEntries().add(entry1);
        person1.getEntries().add(entry2);
        person1 = personRepo.save(person1);
        log.debug("Person 1 : {}", person1);
    }
}
