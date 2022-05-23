package com.example.GuideCane.repository;

import java.util.List;

import com.example.GuideCane.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
    List<Account> findAll();
    Account findByUsername(String username);
//    Optional<Account> findById(String devicecode);
}

