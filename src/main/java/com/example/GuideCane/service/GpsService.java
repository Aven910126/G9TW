package com.example.GuideCane.service;

import com.example.GuideCane.dto.DeviceDTO;
import com.example.GuideCane.dto.GpsDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.Gps;
import com.example.GuideCane.model.Note;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.GpsRepository;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GpsService {
    @Autowired
    private GpsRepository gpsRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private FirebaseMessagingService firebaseMessagingService;
    private Optional<Device> data;
    public List<Gps> findTodayGps(long devicecode){
        data = deviceRepository.findById(devicecode);
        List<Gps> listdata;
        if(data.isPresent()){
            listdata = gpsRepository.findTodayGps(data.get());
        }
        else {
            listdata = new ArrayList<>();
        }
        return listdata;
    }
    public Gps createGps(GpsDTO gpsDTO){
        if(gpsDTO != null){
            String longitude = gpsDTO.getLongitude();
            String latitude = gpsDTO.getLatitude();
            Optional<Device> devicecode = deviceRepository.findById(gpsDTO.getDeviceCode());
            if(devicecode != null){
                Gps gps = gpsRepository.save(new Gps(devicecode.get(),longitude,latitude));
                return gps;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
    public Gps nowGps(long devicecode){
        Optional<Device> data = deviceRepository.findById(devicecode);
        Gps value;
        if(data.isPresent()){
            value = gpsRepository.findMaxTimeGps(data.get());
        }
        else {
            value = null;
        }
        return value;
    }
}
