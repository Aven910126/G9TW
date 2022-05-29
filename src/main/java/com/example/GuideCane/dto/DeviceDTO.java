package com.example.GuideCane.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class DeviceDTO {
    private long deviceCode;
    private boolean bind;
}
