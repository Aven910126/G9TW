package com.example.GuideCane.dto;
import lombok.*;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class AccountDTO {
    private String deviceCode;
    private String username;
    private String password;
}
