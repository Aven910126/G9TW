package com.example.GuideCane.repository;

import java.util.List;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
    List<Account> findAll();
    Account findByUsername(String username);
    Account findByDeviceCode(String DeviceCode);
    Account findOneByDeviceCode(String DeviceCode);
}

