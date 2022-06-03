package com.example.GuideCane.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponseDTO {
    private long deviceCode;
    private String imageData;
}
