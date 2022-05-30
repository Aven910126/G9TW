package com.example.GuideCane.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Sos")
public class SosController {
    @Autowired
    private GpsService gpsService;
    @Autowired
    private EmergencyContactService emergencyContactService;
    @Autowired
    private TestMail testMail;

    @GetMapping("/sos/{devicecode}")
    public ResponseEntity<Gps> createSos(@PathVariable("devicecode") long devicecode){
        try {
            Gps now = gpsService.nowGps(devicecode);
            Gps gps = gpsService.createSos(now);
            List<EmergencyContact> e = emergencyContactService.findAllEmergencyContact(devicecode);
            testMail.sendToGmail(now,e);
            return new ResponseEntity<>(gps, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
