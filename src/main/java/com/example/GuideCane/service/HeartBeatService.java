package com.example.GuideCane.service;
import com.example.GuideCane.dto.HeartbeatDTO;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.model.HeartBeat;
import com.example.GuideCane.repository.AccountRepository;
import com.example.GuideCane.repository.HeartBeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HeartBeatService {

    @Autowired
    private HeartBeatRepository heartBeatRepository;
    @Autowired
    private AccountRepository accountRepository;

    public HeartBeat createHeartBeat(HeartbeatDTO heartbeatDTO){
        String heartBeatValue=heartbeatDTO.getHeartBeatValue();
        Optional<Account> devicecode = accountRepository.findById(heartbeatDTO.getDeviceCode());
        if(devicecode != null){
            HeartBeat heartBeat = heartBeatRepository.save(new HeartBeat(devicecode.get(),heartBeatValue));
            return heartBeat;
        }
        else{
            return null;
        }
    }
    public List<HeartBeat> findAllHeartBeat(long devicecode){
        Optional<Account> data = accountRepository.findById(devicecode);
        List<HeartBeat> listdata;
        if(data.isPresent()){
            listdata = heartBeatRepository.findByDeviceCode(data.get());

        }
        else {
            listdata = new ArrayList<>();
        }
        return listdata;
    }
    public HeartBeat nowHeartBeat(long devicecode){
        Optional<Account> data = accountRepository.findById(devicecode);
        HeartBeat listdata;
        if(data.isPresent()){
            listdata = heartBeatRepository.findMaxTimeHeartBeat(data.get());
        }
        else {
            listdata = null;
        }
        return listdata;
    }


}
