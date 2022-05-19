package com.example.GuideCane.controller;
import java.net.URI;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

import com.example.GuideCane.dto.HeartbeatDTO;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.HeartBeat;
import com.example.GuideCane.repository.AccountRepository;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.HeartBeatRepository;
import com.example.GuideCane.service.HeartBeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/HeartBeat")
public class HeartBeatController {

    @Autowired
    private HeartBeatRepository heartBeatRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private HeartBeatService heartBeatService;

    @Autowired
    private DeviceRepository deviceRepository;

    @PostMapping("/create")
    public ResponseEntity<HeartBeat> createHeartBeat(@RequestBody HeartbeatDTO heartbeatDTO) {
        try{
            String heartBeatValue=heartbeatDTO.getHeartBeatValue();
            Device devicecode = deviceRepository.findByDeviceCode(heartbeatDTO.getDeviceCode());
            if(devicecode != null){
                HeartBeat heartBeat = heartBeatRepository.save(new HeartBeat(devicecode,heartBeatValue));
                return new ResponseEntity<>(heartBeat, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

