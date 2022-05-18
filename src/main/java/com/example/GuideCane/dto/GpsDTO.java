package com.example.GuideCane.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class GpsDTO {
    private String deviceCode;
    private String longitude;
    private String latitude;
}
