package com.example.GuideCane.model;


import com.example.GuideCane.dto.ImageDTO;
import com.example.GuideCane.dto.ImageResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;

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
    private Device deviceCode;
    @Lob
    @Column(name="imagedata")
    private Blob imageData;
    @CreationTimestamp
    @Column(name="createTime")
    private Timestamp createTime;


    public Image(Device deviceCode, Blob imageData) {
        this.deviceCode = deviceCode;
        this.imageData = imageData;
    }
    public String encode64(Image img) throws SQLException {
        Base64.Encoder encoder64 = Base64.getEncoder();
        Blob imagecode=img.getImageData();
        if(imagecode != null){
            byte[] value = null;
            value = imagecode.getBytes(1L,(int)imagecode.length());
            return encoder64.encodeToString(value);
        }
        return null;
    }
}
