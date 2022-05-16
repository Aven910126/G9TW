package com.example.GuideCane.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class EmergencyContactDTO {
    private String deviceCode;
    private String contactPerson;
    private String contactNo;
    private String relationship;
}
