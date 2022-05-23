package com.example.GuideCane.dto;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GpsDTO {
    private long deviceCode;
    private String longitude;
    private String latitude;
}
