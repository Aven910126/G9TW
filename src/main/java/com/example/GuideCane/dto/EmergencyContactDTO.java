package com.example.GuideCane.dto;
import lombok.*;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class EmergencyContactDTO {
    private long deviceCode;
    private String contactPerson;
    private String contactNo;
    private String email;
    private String relationship;
}
