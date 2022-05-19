package com.example.GuideCane.model;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Table(name = "gps")
public class Gps {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "devicecode")
    private Device deviceCode;
    @Column(name="longitude")
    private String longitude;
    @Column(name="latitude")
    private String latitude;

    public Gps(Device deviceCode, String longitude, String latitude) {
        this.deviceCode = deviceCode;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}