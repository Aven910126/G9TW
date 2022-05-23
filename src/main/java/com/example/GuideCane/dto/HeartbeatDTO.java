package com.example.GuideCane.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeartbeatDTO {
    private long deviceCode;
    private String heartBeatValue;
}
