package com.example.GuideCane.dto;
import lombok.*;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class EmergencyContactDTO {
    private long deviceCode;
    private String contactPerson;
    private String contactNumber;
    private String email;
    private String relationship;
    private String password;
}
