package com.example.GuideCane.controller;

import com.example.GuideCane.dto.GpsDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.EmergencyContact;
import com.example.GuideCane.model.Gps;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.GpsRepository;
import com.example.GuideCane.service.EmergencyContactService;
import com.example.GuideCane.service.GpsService;
import com.example.GuideCane.service.TestMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Gps")
public class GpsController {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private GpsRepository gpsRepository;
    @Autowired
    private GpsService gpsService;
    @Autowired
    private EmergencyContactService emergencyContactService;
    @PostMapping("/create")
    public ResponseEntity<Gps> createGps(@RequestBody GpsDTO gpsDTO){
        try {
            Gps gps = gpsService.createGps(gpsDTO);
            return new ResponseEntity<>(gps,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{devicecode}")
    public ResponseEntity<List<Gps>> findTodayGps(@PathVariable("devicecode") long devicecode) {
        try{
            List<Gps> gps = gpsService.findTodayGps(devicecode);
            return new ResponseEntity<>(gps, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/now/{devicecode}")
    public ResponseEntity<Gps> findnowGps(@PathVariable("devicecode") long devicecode) {
        try{
            Gps gps = gpsService.nowGps(devicecode);
            return new ResponseEntity<>(gps, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
