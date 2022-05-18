package com.example.GuideCane.repository;


import java.util.List;

import com.example.GuideCane.model.Account;
import com.example.GuideCane.model.Gps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface GpsRepository extends JpaRepository<Gps,Long> {
    List<Gps> findAll();
    Gps findByDeviceCode(String DeviceCode);
}
