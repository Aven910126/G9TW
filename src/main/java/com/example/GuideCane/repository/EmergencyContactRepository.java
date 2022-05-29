package com.example.GuideCane.repository;

import java.util.List;
import java.util.Optional;

import com.example.GuideCane.model.Device;
import com.example.GuideCane.model.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact,Long>{
    List<EmergencyContact> findAll();
    EmergencyContact findOneByEmailAndDeviceCode(String email, Optional<Device> deviceCode);
    EmergencyContact findFirstByDeviceCode(Device DeviceCode);
    EmergencyContact findByEmail(String email);
    List<EmergencyContact> findByDeviceCode(Device account);
}
