package com.example.GuideCane.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;

@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "devicecode")
    private Account deviceCode;
    @Lob
    @Column(name="imagedata")
    private Blob imageData;
    @CreationTimestamp
    @Column(name="createTime")
    private Timestamp createTime;

    public Image(Account deviceCode, Blob imageData) {
        this.deviceCode = deviceCode;
        this.imageData = imageData;
    }
}
