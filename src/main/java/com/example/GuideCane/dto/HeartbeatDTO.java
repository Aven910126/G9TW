package com.example.GuideCane.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class HeartbeatDTO {
    private String deviceCode;
    private String heartBeatValue;
}
