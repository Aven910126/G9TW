package com.example.GuideCane.service;

import com.example.GuideCane.dto.GpsDTO;
import com.example.GuideCane.dto.ImageDTO;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.model.Gps;
import com.example.GuideCane.model.Image;
import com.example.GuideCane.repository.AccountRepository;
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
    private AccountRepository accountRepository;

    public Image createImage(ImageDTO imageDTO){
        Blob imageData = imageDTO.getImageData();
        Optional<Account> devicecode = accountRepository.findById(imageDTO.getDeviceCode());
        if(devicecode != null){
            Image image = imageRepository.save(new Image(devicecode.get(),imageData));
            return image;
        }
        else{
            return null;
        }
    }
    public Image nowImage(long devicecode){
        Optional<Account> data = accountRepository.findById(devicecode);
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
