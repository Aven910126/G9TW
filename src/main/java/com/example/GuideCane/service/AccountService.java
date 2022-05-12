package com.example.GuideCane.service;
//import java.util.*;
//import com.example.GuideCane.model.Account;
//import com.example.GuideCane.repository.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//@Service
//public class AccountService {
//    private AccountRepository accountRepository;
//    @Autowired
//    public AccountService(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }
//    public Account createAccount(Account request){
////        Account devicecode = accountRepository.findByDeviceCode(request.getDeviceCode());
////        if(devicecode != null){
////            throw new Exception("The id of the product is duplicated.");
////        }
//        Account account = new Account();
//        account.setName(request.getName());
//        account.setDeviceCode(request.getDeviceCode());
//        return accountRepository.save(account);
//    }
//    public Account findUserByDeviceCode(String DeviceCode) {
//        return accountRepository.findByDeviceCode(DeviceCode);
//    }
//
//    public Account findUserByUserName(String userName) {
//        return accountRepository.findByName(userName);
//    }
//
//}
import com.example.GuideCane.model.Account;
import com.example.GuideCane.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
//    public Account createAccount(Account request) {
//        Account account = new Account();
//        account.setUsername(request.getUsername());
//        account.setPassword(request.getPassword());
//        account.setDevicecode(request.getDevicecode());
//
//        return accountRepository.save(account);
//    }
}
