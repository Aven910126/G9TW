package com.example.GuideCane.service;
import com.example.GuideCane.model.HeartBeat;
import com.example.GuideCane.repository.HeartBeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HeartBeatService {

    @Autowired
    private HeartBeatRepository heartBeatRepository;

    public HeartBeatService(HeartBeatRepository heartBeatRepository) {

        this.heartBeatRepository = heartBeatRepository;
    }

}
