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
    @Column(name="contact_Name")
    private String contactPerson;
    @Column(name="contact_Number")
    private String contactNumber;
    @Column(name="contact_Email")
    private String email;
    @Column(name="contact_Relationship")
    private String relationship;
    @Column(name="contact_password")
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
