package com.example.GuideCane.model;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Data
@Table(name = "account")
public class Account {
    @Id
    @Column(name="devicecode")
    private long deviceCode;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    public Account(long device, String username, String password) {
        this.deviceCode = device;
        this.username = username;
        this.password = password;
    }
}
