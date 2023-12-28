package com.mission42.dto;

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
    private long personId;
}
