package com.example.GuideCane.controller;
import java.util.List;

import com.example.GuideCane.dto.HeartbeatDTO;
import com.example.GuideCane.model.HeartBeat;
import com.example.GuideCane.repository.AccountRepository;
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

    @PostMapping("/create")
    public ResponseEntity<HeartBeat> createHeartBeat(@RequestBody HeartbeatDTO heartbeatDTO) {
        try{
            HeartBeat heartBeat = heartBeatService.createHeartBeat(heartbeatDTO);
            return new ResponseEntity<>(heartBeat, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find/{devicecode}")
    public ResponseEntity<List<HeartBeat>> findHeartBeat(@PathVariable("devicecode") long devicecode) {
        try{
            List<HeartBeat> heartBeat = heartBeatService.findAllHeartBeat(devicecode);
            return new ResponseEntity<>(heartBeat, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/now/{devicecode}")
    public ResponseEntity<HeartBeat> nowHeartBeat(@PathVariable("devicecode") long devicecode) {
        try{
            HeartBeat heartBeat = heartBeatService.nowHeartBeat(devicecode);
            return new ResponseEntity<>(heartBeat, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

