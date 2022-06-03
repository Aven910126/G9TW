package com.example.GuideCane.service;

import com.example.GuideCane.dto.ImageDTO;
import com.example.GuideCane.dto.ImageResponseDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.Image;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    Base64.Encoder encoder64 = Base64.getEncoder();
    public Image createImage(ImageDTO imageDTO){
        Blob imageData = imageDTO.getImageData();
        Optional<Device> devicecode = deviceRepository.findById(imageDTO.getDeviceCode());
        if(devicecode != null){
            Image image = imageRepository.save(new Image(devicecode.get(),imageData));
            return image;
        }
        else{
            return null;
        }
    }
    public ImageResponseDTO nowImage(long devicecode,Image imagedata) throws SQLException {
        Optional<Device> data = deviceRepository.findById(devicecode);
        Image listdata;
        ImageResponseDTO image = new ImageResponseDTO();
        if(data.isPresent()){
            listdata = imageRepository.findMaxTimeImage(data.get());
            image = new ImageResponseDTO(listdata.getDeviceCode().getDeviceCode(),null);
            String value = imagedata.encode64(listdata);
            image.setImageData(value);
        }
        else {
            listdata = null;
        }
        return image;
    }
}
