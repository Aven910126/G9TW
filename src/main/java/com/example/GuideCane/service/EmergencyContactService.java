package com.example.GuideCane.service;

import com.example.GuideCane.repository.EmergencyContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyContactService {
    @Autowired
    private EmergencyContactRepository emergencyContactRepository;

    public EmergencyContactService(EmergencyContactRepository emergencyContactRepository) {
        this.emergencyContactRepository = emergencyContactRepository;
    }
}
