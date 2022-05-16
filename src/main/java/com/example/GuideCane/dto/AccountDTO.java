package com.example.GuideCane.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AccountDTO {
    private String deviceCode;
    private String username;
    private String password;
}
