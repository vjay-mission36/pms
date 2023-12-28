package com.mission42.controller;

import com.mission42.dto.FeeEntryDTO;
import com.mission42.model.FeeEntry;
import com.mission42.service.FeeEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entries")
public class FeeEntryController {

    @Autowired
    private FeeEntryService feeEntryService;

    @PostMapping
    public ResponseEntity<String> addBulkEntries(@RequestBody List<FeeEntryDTO> feeEntries){
        StringBuilder strBuilder = new StringBuilder();
        boolean flag = feeEntryService.updateBulkFeeEntries(feeEntries);
        if(flag){
            strBuilder.append("Fee Entries are appended {} "+feeEntries.get(0).getPersonId());
            return ResponseEntity.status(HttpStatus.OK).body(strBuilder.toString());
        }else{
            strBuilder.append("Some thing went wrong .. Please try again");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(strBuilder.toString());
        }
    }
}
