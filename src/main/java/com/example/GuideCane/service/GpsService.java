package com.example.GuideCane.service;

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

    public Gps createGps(GpsDTO gpsDTO){
        String longitude = gpsDTO.getLongitude();
        String latitude = gpsDTO.getLatitude();
        Boolean sosInfo = false;
        Optional<Device> devicecode = deviceRepository.findById(gpsDTO.getDeviceCode());
        if(devicecode != null){
            Gps gps = gpsRepository.save(new Gps(devicecode.get(),longitude,latitude,sosInfo));
            return gps;
        }
        else{
            return null;
        }
    }
    public Gps createSos(Gps gps) throws FirebaseMessagingException {
        Note note=new Note();
        String longitude = gps.getLongitude();
        String latitude = gps.getLatitude();
        Gps sos = gpsRepository.findMaxTimeGps(gps.getDeviceCode());
        sos.setSosInfo(true);
        Device devicecode = gps.getDeviceCode();
        if(devicecode != null){
            Gps g = gpsRepository.save(sos);
            note.setSubject("SOS message");
            note.setContent("Go to the location function to view");
            firebaseMessagingService.sendNotification(note,"c4sPMDP0Sgm8j28zJTyJY_:APA91bFN4-PJGS39xkmzAJiMNy9KkH8IPiYkmfQC6z37Tn09zrj6Gnm4nUP2h6i2rWcigppBSf_ufHJGlSW4cV_4x9oQa_AMvkvjArlWd8da8Om6N7oXdqL0zwpWLzI9G72FhKky3OZ9");
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
        Device devicecode = gps.getDeviceCode();
        if(devicecode != null){
            Gps g = gpsRepository.save(sos);
            return g;
        }
        else{
            return null;
        }
    }
    public List<Gps> findTodayGps(long devicecode){
        Optional<Device> data = deviceRepository.findById(devicecode);
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
        Optional<Device> data = deviceRepository.findById(devicecode);
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
