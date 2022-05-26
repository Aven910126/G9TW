package com.example.GuideCane.controller;
import java.util.List;

import com.example.GuideCane.dto.EmergencyContactDTO;
import com.example.GuideCane.dto.SosDTO;
import com.example.GuideCane.model.EmergencyContact;
import com.example.GuideCane.repository.AccountRepository;
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
    private AccountRepository accountRepository;

    EmergencyContact e = null;
    @PostMapping("/create")
    public ResponseEntity<EmergencyContact> createEmergencyContact(@RequestBody EmergencyContactDTO emergencyContactDTO) {
        try{
            EmergencyContact emergencyContact = emergencyContactService.createEmergencyContact(emergencyContactDTO);
            if(emergencyContact == null){
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(emergencyContact, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/sos")
//    public ResponseEntity<EmergencyContact> sos(@RequestBody SosDTO sosDTO) {
//        try{
//            EmergencyContact emergencyContact = emergencyContactService.sos(sosDTO);
//            e = emergencyContact;
//            if(emergencyContact == null){
//                return new ResponseEntity<>(null, HttpStatus.CREATED);
//            }else{
//                return new ResponseEntity<>(emergencyContact, HttpStatus.OK);
//            }
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/find/{devicecode}")
    public ResponseEntity<List<EmergencyContact>> findEmergencyContact(@PathVariable("devicecode") long devicecode) {
        try{
            List<EmergencyContact> emergencyContact = emergencyContactService.findAllEmergencyContact(devicecode);

            return new ResponseEntity<>(emergencyContact, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
