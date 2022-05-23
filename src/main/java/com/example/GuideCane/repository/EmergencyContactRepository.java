package com.example.GuideCane.repository;

import java.util.List;
import java.util.Optional;

import com.example.GuideCane.model.Account;
import com.example.GuideCane.model.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact,Long>{
    List<EmergencyContact> findAll();
    EmergencyContact findOneByRelationshipAndDeviceCode(String Relationship, Optional<Account> deviceCode);

    List<EmergencyContact> findByDeviceCode(Account account);
}
