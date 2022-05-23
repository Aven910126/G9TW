package com.example.GuideCane.dto;

import lombok.*;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class LoginDTO {
    private long deviceCode;
    private String password;
}
