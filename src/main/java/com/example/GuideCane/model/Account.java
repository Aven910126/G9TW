package com.example.GuideCane.model;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "devicecode")
    private Device deviceCode;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    public Account(Device device, String username, String password) {
        this.deviceCode = device;
        this.username = username;
        this.password = password;
    }
}
