package com.example.GuideCane.controller;

import com.example.GuideCane.dto.ImageDTO;
import com.example.GuideCane.dto.ImageResponseDTO;
import com.example.GuideCane.model.Gps;
import com.example.GuideCane.model.Image;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.ImageRepository;
import com.example.GuideCane.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Image")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private DeviceRepository deviceRepository;
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
    @GetMapping("/now/{devicecode}")
    public ResponseEntity<ImageResponseDTO> nowImg(@PathVariable("devicecode") long devicecode) {
        try{
            Image image = new Image();
            ImageResponseDTO img = imageService.nowImage(devicecode,image);
            return new ResponseEntity<>(img, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
