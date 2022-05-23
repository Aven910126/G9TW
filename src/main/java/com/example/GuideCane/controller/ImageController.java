package com.example.GuideCane.controller;

import com.example.GuideCane.dto.HeartbeatDTO;
import com.example.GuideCane.dto.ImageDTO;
import com.example.GuideCane.model.HeartBeat;
import com.example.GuideCane.model.Image;
import com.example.GuideCane.repository.AccountRepository;
import com.example.GuideCane.repository.ImageRepository;
import com.example.GuideCane.service.HeartBeatService;
import com.example.GuideCane.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Image")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ImageService imageService;
    @PostMapping("/create")
    public ResponseEntity<Image> createImage(@RequestBody ImageDTO imageDTO) {
        try{
            Image image = imageService.createImage(imageDTO);
            return new ResponseEntity<>(image, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
