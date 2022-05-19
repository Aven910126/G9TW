package com.example.GuideCane.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeartbeatDTO {
    private String deviceCode;
    private String heartBeatValue;
}
