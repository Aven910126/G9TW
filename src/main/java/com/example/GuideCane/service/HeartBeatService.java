package com.example.GuideCane.service;
import com.example.GuideCane.dto.HeartbeatDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.HeartBeat;
import com.example.GuideCane.model.Note;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.HeartBeatRepository;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeartBeatService {

    Note note=new Note();

    @Autowired
    private HeartBeatRepository heartBeatRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private FirebaseMessagingService firebaseMessagingService;

    private int notify_frequency;
    private String msg="HeartBeat Abnormal reminder";
    public HeartBeat createHeartBeat(HeartbeatDTO heartbeatDTO) throws FirebaseMessagingException {
        String heartBeatValue=heartbeatDTO.getHeartBeatValue();
        Optional<Device> devicecode = deviceRepository.findById(heartbeatDTO.getDeviceCode());
        if(devicecode != null){
            HeartBeat heartBeat = heartBeatRepository.save(new HeartBeat(devicecode.get(),heartBeatValue));
            if(Integer.parseInt(heartBeatValue) < 60 || Integer.parseInt(heartBeatValue) >= 100){
                try {
                    note.setSubject(msg);
                    note.setContent("Abnormal heart rhythm value is"+heartBeatValue);
                    firebaseMessagingService.sendNotification(note,"c4sPMDP0Sgm8j28zJTyJY_:APA91bFN4-PJGS39xkmzAJiMNy9KkH8IPiYkmfQC6z37Tn09zrj6Gnm4nUP2h6i2rWcigppBSf_ufHJGlSW4cV_4x9oQa_AMvkvjArlWd8da8Om6N7oXdqL0zwpWLzI9G72FhKky3OZ9");
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            return heartBeat;
        }
        else{
            return null;
        }
    }
    public List<HeartBeat> findAllHeartBeat(long devicecode){
        Optional<Device> data = deviceRepository.findById(devicecode);
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
        Optional<Device> data = deviceRepository.findById(devicecode);
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
