package com.example.GuideCane.service;

import com.example.GuideCane.dto.DeviceDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device createAccount(Device device, DeviceDTO deviceDTO){
        Device data = deviceRepository.findByDeviceCode(device.getDeviceCode());
        data.setBind(true);
        long devicecode = device.getDeviceCode();
        long _devicecode = deviceDTO.getDeviceCode();
        if(devicecode == _devicecode){
            Device a = deviceRepository.save(data);
            return a;
        }else{
            return null;
        }
    }
    public Device findData(long devicecode){
        Device data = deviceRepository.findByDeviceCode(devicecode);
        return data;
    }
}
