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
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="devicecode",unique = true)
    private String deviceCode;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    public Account(String devicecode, String username, String password) {
        this.deviceCode = devicecode;
        this.username = username;
        this.password = password;
    }
}
