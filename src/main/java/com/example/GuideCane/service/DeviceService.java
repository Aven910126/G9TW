package com.example.GuideCane.service;

import com.example.GuideCane.model.Account;
import com.example.GuideCane.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

}
