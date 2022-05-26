package com.example.GuideCane.model;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Table(name = "emergencyContact")
public class EmergencyContact {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "devicecode")
    private Account deviceCode;
    @Column(name="contactPerson")
    private String contactPerson;
    @Column(name="contactNo")
    private String contactNo;
    @Column(name="email")
    private String email;
    @Column(name="Relationship")
    private String relationship;

    public EmergencyContact(Account deviceCode, String contactPerson, String contactNo, String relationship,String email) {
        this.deviceCode = deviceCode;
        this.contactPerson = contactPerson;
        this.contactNo = contactNo;
        this.relationship = relationship;
        this.email = email;
    }
}
