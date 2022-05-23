package com.example.GuideCane.repository;

import com.example.GuideCane.model.Account;
import com.example.GuideCane.model.HeartBeat;
import com.example.GuideCane.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Long>{
    List<Image> findAll();
    List<Image> findByDeviceCode(Account DeviceCode);
    @Query(value = "SELECT *  FROM `image` WHERE `devicecode` = :DeviceCode ORDER BY create_time DESC LIMIT 0 , 1",nativeQuery = true)
    Image findMaxTimeImage(Account DeviceCode);
}
