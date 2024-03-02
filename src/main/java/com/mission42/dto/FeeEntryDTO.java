package com.mission42.dto;

import com.mission42.model.Person;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FeeEntryDTO {
    private Date entryDate;
    private double amount;
    private Long personId;
}
