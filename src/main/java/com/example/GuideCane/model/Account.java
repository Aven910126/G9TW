package com.example.GuideCane.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="DeviceCode")
    private String DeviceCode;
    @Column(name="Name")
    private String Name;
    @Column(name="PASSWORD")
    private String password;

}
