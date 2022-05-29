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
    private Device deviceCode;
    @Column(name="contactPerson")
    private String contactPerson;
    @Column(name="contactNumber")
    private String contactNumber;
    @Column(name="email")
    private String email;
    @Column(name="Relationship")
    private String relationship;
    @Column(name="password")
    private String password;

    public EmergencyContact(Device deviceCode, String contactPerson, String contactNumber, String relationship,String email,String password) {
        this.deviceCode = deviceCode;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.relationship = relationship;
        this.email = email;
        this.password = password;
    }
}
