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
    private String username;//創造
    @Column(name="password")
    private String password;

    public void setUsername(String username) {
        this.username = username;//使用自己的方法Lod1
    }

    public Account(long device, String username, String password) {
        this.deviceCode = device;
        this.username = username;
        this.password = password;
    }
}
