package com.example.GuideCane.service;

import com.example.GuideCane.dto.EmergencyContactDTO;
import com.example.GuideCane.dto.LoginDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.EmergencyContact;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.EmergencyContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmergencyContactService {
    @Autowired
    private EmergencyContactRepository emergencyContactRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

   public EmergencyContact createEmergencyContact(EmergencyContactDTO emergencyContactDTO){
       String contactPerson=emergencyContactDTO.getContactPerson();//使用到別人傳進來的參數Lod3
       String contactNumber=emergencyContactDTO.getContactNumber();
       Optional<Device> deviceCode=deviceRepository.findById(emergencyContactDTO.getDeviceCode());//使用自己的物件Lod2
       String relationship=emergencyContactDTO.getRelationship();
       String email=emergencyContactDTO.getEmail();
       String password=passwordEncoder.encode(emergencyContactDTO.getPassword());
       if(emergencyContactRepository.findOneByEmailAndDeviceCode(email,deviceCode)!=null){
           return null;
       }else{
           if(deviceCode!=null){
               EmergencyContact emergencyContact = emergencyContactRepository.save(new EmergencyContact(deviceCode.get(),contactPerson,contactNumber,relationship,email,password));
               return emergencyContact;
           }
           else{
               return null;
           }
       }
   }


    public List<EmergencyContact> findAllEmergencyContact(long devicecode){
        Optional<Device> data = deviceRepository.findById(devicecode);
        List<EmergencyContact> listdata;
        if(data.isPresent()){
            listdata = emergencyContactRepository.findByDeviceCode(data.get());
        }
        else {
            listdata = new ArrayList<>();
        }
        return listdata;
    }
    public EmergencyContact login(LoginDTO loginDTO){
        String email=loginDTO.getEmail();
        String password=loginDTO.getPassword();
        EmergencyContact emergencyContact = emergencyContactRepository.findByEmail(email);
        System.out.println(emergencyContact);
        String _email = emergencyContact.getEmail();
        String _password = emergencyContact.getPassword();
        if(email.equals(_email)  && passwordEncoder.matches(password,_password)){
            return emergencyContact;
        }else{
            return null;
        }
    }
}
