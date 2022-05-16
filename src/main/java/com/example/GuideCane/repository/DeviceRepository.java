package com.example.GuideCane.repository;

import java.util.List;

import com.example.GuideCane.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long>{
//    @Query(value = "select * from Device where  devicecode = :DeviceCode",nativeQuery = true)
    Device findByDeviceCode(String DeviceCode);
}
