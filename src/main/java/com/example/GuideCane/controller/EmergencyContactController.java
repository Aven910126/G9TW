package com.example.GuideCane.controller;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.example.GuideCane.dto.EmergencyContactDTO;
import com.example.GuideCane.dto.RelationshipDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.EmergencyContact;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.repository.EmergencyContactRepository;
import com.example.GuideCane.service.EmergencyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/EmergencyContact")
public class EmergencyContactController {

    @Autowired
    private EmergencyContactRepository emergencyContactRepository;
    @Autowired
    private EmergencyContactService emergencyContactService;
    @Autowired
    private DeviceRepository deviceRepository;
    @PostMapping("/create")
    public ResponseEntity<EmergencyContact> createEmergencyContact(@RequestBody EmergencyContactDTO emergencyContactDTO) {
        try{
            String contactPerson=emergencyContactDTO.getContactPerson();
            String contactNo=emergencyContactDTO.getContactNo();
            Device deviceCode=deviceRepository.findByDeviceCode(emergencyContactDTO.getDeviceCode());
            String relationship=emergencyContactDTO.getRelationship();
            if(emergencyContactRepository.findOneByRelationshipAndContactNo(relationship,contactNo)!=null){
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }else{
                if(deviceCode!=null){
                    EmergencyContact emergencyContact = emergencyContactRepository.save(new EmergencyContact(deviceCode,contactPerson,contactNo,relationship));
                    return new ResponseEntity<>(emergencyContact, HttpStatus.OK);
                }
                else{
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/relationship")
    public ResponseEntity<EmergencyContact> findByRelationship(@RequestBody RelationshipDTO relationshipDTO) {
        try{
            String relationship=relationshipDTO.getRelationship();
            String contactNo =relationshipDTO.getContactNo();
            if(emergencyContactRepository.findOneByRelationshipAndContactNo(relationship,contactNo)==null){
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }else{
                EmergencyContact emergencyContact=emergencyContactRepository.findOneByRelationshipAndContactNo(relationship,contactNo);

                return new ResponseEntity<>(emergencyContact, HttpStatus.OK);
            }

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
