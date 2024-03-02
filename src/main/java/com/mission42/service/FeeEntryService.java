package com.mission42.service;

import com.mission42.dto.FeeEntryDTO;
import com.mission42.model.FeeEntry;
import com.mission42.model.Person;
import com.mission42.repo.FeeEntryRepo;
import com.mission42.util.PMSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FeeEntryService {

    private final Logger LOG = LoggerFactory.getLogger(FeeEntryService.class);
    Function<FeeEntryDTO, FeeEntry> feeEntryMap = feeEntryDTO -> {
        return FeeEntry.builder().entryDate(feeEntryDTO.getEntryDate()).amount(feeEntryDTO.getAmount()).build();
    };

    @Autowired
    private FeeEntryRepo feeEntryRepo;
    @Autowired
    private PersonService personService;

    public List<FeeEntry> getAllEntries4Person(Date entryDate, Person person) {
        LocalDate startDateLocalDate = PMSUtils.getLocalDateInstance(entryDate);
        int year = startDateLocalDate.getYear();
        LocalDate startDate = LocalDate.of(year, 01, 01);
        LocalDate endDate = LocalDate.of(year, 12, 31);
        LOG.debug("getAllEntries4Person : EntryDate : {}, Person: {}, start date: {} ,end date :{}", entryDate, person, startDate, endDate);
        return feeEntryRepo.findByEntryDateBetweenAndPerson(PMSUtils.getDateFromLocalDate(startDate), PMSUtils.getDateFromLocalDate(endDate), person);
    }

    public List<FeeEntry> getAllEntries4Person(String year, String personId) {
        List<FeeEntry> entries = Collections.EMPTY_LIST;
        return entries;
    }

    /*
     * adding the fee entry
     */
    public FeeEntry addEntryByPerson(FeeEntry feeEntry) {
        LOG.debug("addEntryByPerson: {}", feeEntry);
        return feeEntryRepo.save(feeEntry);
    }

    public boolean updateBulkFeeEntries(List<FeeEntryDTO> feeEntries) {
        if (feeEntries == null || feeEntries.isEmpty()) {
            throw new RuntimeException();
        } else {
            Long id = feeEntries.get(0).getPersonId();
            Person p = personService.getPersonById(id);
            Set<FeeEntry> entries = feeEntries.stream().map(feeEntryMap).collect(Collectors.toSet());
            LOG.debug("Entries :{} ", entries);

            // update Person with fee entry
            for (FeeEntry feeEntry : entries) {
                feeEntry.setPerson(p);
            }
            LOG.debug("feeEntry after setting Person: {}", entries);
            boolean flag = p.getEntries().addAll(entries);

            feeEntryRepo.saveAll(entries);
            LOG.debug(" updateBulkFeeEntries - After appending {} ", flag);

            return flag;
        }
    }
}
