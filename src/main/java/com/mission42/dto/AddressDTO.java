package com.mission42.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressDTO {
    private String type; // latter can be converted enum would be better choice
    private String line1;
    private String line2;
    private String village;
    private String state;
    private String pin;
}
