package com.example.GuideCane.repository;

import java.util.List;

import com.example.GuideCane.model.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact,Long>{
    List<EmergencyContact> findAll();
    EmergencyContact findByContactPerson(String ContactPerson);
    EmergencyContact findByContactNo(String ContactNo);
    EmergencyContact findByDeviceCode(String DeviceCode);
    EmergencyContact findOneByRelationshipAndContactNo(String Relationship,String ContactNo);
}
