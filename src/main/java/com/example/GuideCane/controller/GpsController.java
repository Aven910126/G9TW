package com.example.GuideCane.controller;

import com.example.GuideCane.dto.GpsDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.Gps;
import com.example.GuideCane.model.HeartBeat;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.GpsRepository;
import com.example.GuideCane.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Gps")
public class GpsController {

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private GpsRepository gpsRepository;
    @Autowired
    private GpsService gpsService;
    @PostMapping("/create")
    public ResponseEntity<Gps> createGps(@RequestBody GpsDTO gpsDTO){
        try {
            String longitude = gpsDTO.getLongitude();
            String latitude = gpsDTO.getLatitude();
            Device devicecode = deviceRepository.findByDeviceCode(gpsDTO.getDeviceCode());
            if(devicecode != null){
                Gps gps = gpsRepository.save(new Gps(devicecode,longitude,latitude));
                return new ResponseEntity<>(gps, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
