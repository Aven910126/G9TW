package com.example.GuideCane.service;

import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.Gps;
import com.example.GuideCane.model.Note;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.GpsRepository;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SosService {
    @Autowired
    private GpsRepository gpsRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private FirebaseMessagingService firebaseMessagingService;
    private String token = "c4sPMDP0Sgm8j28zJTyJY_:APA91bFN4-PJGS39xkmzAJiMNy9KkH8IPiYkmfQC6z37Tn09zrj6Gnm4nUP2h6i2rWcigppBSf_ufHJGlSW4cV_4x9oQa_AMvkvjArlWd8da8Om6N7oXdqL0zwpWLzI9G72FhKky3OZ9";

    public Gps SoS(Gps gps) throws FirebaseMessagingException {
        Note note=new Note();
        String longitude = gps.getLongitude();
        String latitude = gps.getLatitude();
        Gps sos = gpsRepository.findMaxTimeGps(gps.getDeviceCode());
        Device devicecode = gps.getDeviceCode();
        if(devicecode != null){
            note.setSubject("SOS message");
            note.setContent("Go to the location function to view");
            note.getData().put("key_1","https://www.google.com.tw/");
            firebaseMessagingService.sendNotification(note,token);
            return gps;
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
