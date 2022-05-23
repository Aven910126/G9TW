package com.example.GuideCane.dto;
import lombok.*;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class AccountDTO {
    private long deviceCode;
    private String username;
    private String password;
}
