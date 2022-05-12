package com.example.GuideCane.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.example.GuideCane.repository.AccountRepository;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.service.AccountService;
import com.example.GuideCane.dto.AccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createProduct(@RequestBody AccountDTO accountDTO) {
        try{
            String username=accountDTO.getUsername();
            String password=accountDTO.getPassword();
            String deviceCode=accountDTO.getDeviceCode();
            System.out.println(username);
            System.out.println(password);
            System.out.println(deviceCode);
            System.out.println(accountRepository.findByDeviceCode(deviceCode)==null);
            if(accountRepository.findByDeviceCode(deviceCode)!=null){
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }else{

                Account account = accountRepository.save(new Account(deviceCode,username,password));
                return new ResponseEntity<>(account, HttpStatus.CREATED);
            }

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(account.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).body(account);
    }
}
