package com.example.GuideCane.service;

import com.example.GuideCane.repository.GpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GpsService {
    @Autowired
    private GpsRepository gpsRepository;

    public GpsService(GpsRepository gpsRepository) {
        this.gpsRepository = gpsRepository;
    }
}
