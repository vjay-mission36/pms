package com.mission42.repo;

import com.mission42.model.FeeEntry;
import com.mission42.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FeeEntryRepo extends JpaRepository<FeeEntry, Long> {
    public List<FeeEntry> findByPerson(Person person);
    public List<FeeEntry> findByEntryDateBetweenAndPerson(Date startDate, Date endDate, Person person);

}
