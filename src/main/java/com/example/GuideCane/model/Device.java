package com.example.GuideCane.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "devicecode")
    private String deviceCode;
}
