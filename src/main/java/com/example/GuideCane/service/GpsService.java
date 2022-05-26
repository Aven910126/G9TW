package com.example.GuideCane.service;

import com.example.GuideCane.dto.GpsDTO;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.model.Gps;
import com.example.GuideCane.model.HeartBeat;
import com.example.GuideCane.repository.AccountRepository;
import com.example.GuideCane.repository.GpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GpsService {
    @Autowired
    private GpsRepository gpsRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Gps createGps(GpsDTO gpsDTO){
        String longitude = gpsDTO.getLongitude();
        String latitude = gpsDTO.getLatitude();
        Boolean sosInfo = false;
        Optional<Account> devicecode = accountRepository.findById(gpsDTO.getDeviceCode());
        if(devicecode != null){
            Gps gps = gpsRepository.save(new Gps(devicecode.get(),longitude,latitude,sosInfo));
            return gps;
        }
        else{
            return null;
        }
    }
    public Gps createSos(Gps gps){
        String longitude = gps.getLongitude();
        String latitude = gps.getLatitude();
        Gps sos = gpsRepository.findMaxTimeGps(gps.getDeviceCode());
        sos.setSosInfo(true);
        Account devicecode = gps.getDeviceCode();
        if(devicecode != null){
            Gps g = gpsRepository.save(sos);
            return g;
        }
        else{
            return null;
        }
    }
    public Gps relievesos(Gps gps){
        String longitude = gps.getLongitude();
        String latitude = gps.getLatitude();
        Gps sos = gpsRepository.findMaxTimeGps(gps.getDeviceCode());
        sos.setSosInfo(false);
        Account devicecode = gps.getDeviceCode();
        if(devicecode != null){
            Gps g = gpsRepository.save(sos);
            return g;
        }
        else{
            return null;
        }
    }
    public List<Gps> findTodayGps(long devicecode){
        Optional<Account> data = accountRepository.findById(devicecode);
        List<Gps> listdata;
        if(data.isPresent()){
            listdata = gpsRepository.findTodayGps(data.get());
        }
        else {
            listdata = new ArrayList<>();
        }
        return listdata;
    }
    public Gps nowGps(long devicecode){
        Optional<Account> data = accountRepository.findById(devicecode);
        Gps listdata;
        if(data.isPresent()){
            listdata = gpsRepository.findMaxTimeGps(data.get());
        }
        else {
            listdata = null;
        }
        return listdata;
    }


}
