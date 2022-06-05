package com.example.GuideCane.controller;

import com.example.GuideCane.dto.GpsDTO;
import com.example.GuideCane.model.EmergencyContact;
import com.example.GuideCane.model.Gps;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.GpsRepository;
import com.example.GuideCane.service.EmergencyContactService;
import com.example.GuideCane.service.GpsService;
import com.example.GuideCane.service.SosService;
import com.example.GuideCane.service.TestMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Sos")
public class SosController {
    @Autowired
    private SosService sosService;
    @Autowired
    private GpsService gpsService;
    @Autowired
    private EmergencyContactService emergencyContactService;
    @Autowired
    private TestMail testMail;

    @PostMapping("/creatsos/")
    public ResponseEntity<Gps> createSos(@RequestBody GpsDTO gpsDTO){
        try {
            Gps creatgps = gpsService.createGps(gpsDTO);
            long devicecode = gpsDTO.getDeviceCode();
            Gps nowgps = sosService.nowGps(devicecode);
            Gps sos = sosService.SoS(nowgps);
            List<EmergencyContact> e = emergencyContactService.findAllEmergencyContact(devicecode);
            System.out.println(nowgps);
            System.out.println(e);
            testMail.sendToGmail(nowgps,e);
            return new ResponseEntity<>(sos, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
