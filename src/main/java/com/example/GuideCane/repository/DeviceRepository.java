package com.example.GuideCane.repository;
import java.util.List;

import com.example.GuideCane.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface DeviceRepository extends JpaRepository<Device,Long>{
    List<Device> findAll();

    Device findByDeviceCode(long DeviceCode);

}
