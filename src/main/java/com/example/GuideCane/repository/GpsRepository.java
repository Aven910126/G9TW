package com.example.GuideCane.repository;


import java.util.List;

import com.example.GuideCane.model.Account;
import com.example.GuideCane.model.Gps;
import com.example.GuideCane.model.HeartBeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface GpsRepository extends JpaRepository<Gps,Long> {
    List<Gps> findAll();
    List<Gps> findByDeviceCode(Account DeviceCode);
    @Query(value = "SELECT *  FROM `gps` WHERE `devicecode` = :DeviceCode ORDER BY create_time DESC LIMIT 0 , 1",nativeQuery = true)
    Gps findMaxTimeGps(Account DeviceCode);
    @Query(value = "SELECT * FROM `gps` WHERE `devicecode` = :DeviceCode ORDER BY CURDATE()",nativeQuery = true)
    List<Gps> findTodayGps(Account DeviceCode);
}
