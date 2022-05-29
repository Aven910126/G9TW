package com.example.GuideCane.controller;


import com.example.GuideCane.dto.DeviceDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.repository.DeviceRepository;
import com.example.GuideCane.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Device")
public class DeviceController {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private DeviceService deviceService;
    @PatchMapping("/create/{devicecode}")
    public ResponseEntity<Device> createAccount(@PathVariable("devicecode") long devicecode, @RequestBody DeviceDTO deviceDTO){
        try {
            Device data = deviceService.findData(devicecode);
            Device device = deviceService.createAccount(data,deviceDTO);
            return new ResponseEntity<>(device, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/finduser/{devicecode}")
    public ResponseEntity<Device> findData(@PathVariable("devicecode") long devicecode) {
        try{
            Device device = deviceRepository.findByDeviceCode(devicecode);
            return new ResponseEntity<>(device, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
