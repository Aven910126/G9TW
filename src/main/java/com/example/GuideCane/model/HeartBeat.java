package com.example.GuideCane.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Table(name = "heartBeat")
public class HeartBeat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "devicecode")
    private Device deviceCode;
    @Column(name="heartBeatValue")
    private String heartBeatValue;
    @CreationTimestamp
    @Column(name="createTime")
    private Timestamp createTime;

    public HeartBeat(Device deviceCode, String heartBeatValue) {
        this.deviceCode = deviceCode;
        this.heartBeatValue = heartBeatValue;
    }

}
