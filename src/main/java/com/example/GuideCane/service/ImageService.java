package com.example.GuideCane.service;

import com.example.GuideCane.dto.ImageDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.Image;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.Optional;
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private DeviceRepository deviceRepository;

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
    public Image nowImage(long devicecode){
        Optional<Device> data = deviceRepository.findById(devicecode);
        Image listdata;
        if(data.isPresent()){
            listdata = imageRepository.findMaxTimeImage(data.get());
        }
        else {
            listdata = null;
        }
        return listdata;
    }
}
