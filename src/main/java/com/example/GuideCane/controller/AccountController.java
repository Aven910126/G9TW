package com.example.GuideCane.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.example.GuideCane.dto.LoginDTO;
import com.example.GuideCane.model.Device;
import com.example.GuideCane.repository.AccountRepository;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.repository.DeviceRepository;
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
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO) {
        try{
            String username=accountDTO.getUsername();
            String password=accountDTO.getPassword();
            Device devicecode=deviceRepository.findByDeviceCode(accountDTO.getDeviceCode());
            Boolean check=false;
            List<Account> accountList= accountRepository.findAll();
            for(Account a:accountList){
                if(a.getDeviceCode().equals(accountDTO.getDeviceCode())){
                    check=true;
                    break;
                }
            }
            if(check){
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }else{
                Account account = accountRepository.save(new Account(devicecode,username,password));
                return new ResponseEntity<>(account, HttpStatus.OK);
            }

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Account> loginAccount(@RequestBody LoginDTO loginDTO) {
        try{
            String username=loginDTO.getUsername();
            String password=loginDTO.getPassword();
            Account userData = accountRepository.findByUsername(username);
            String _username = accountRepository.findByUsername(username).getUsername();
            String _password = accountRepository.findByUsername(username).getPassword();
            if(username.equals(_username) && password.equals(_password)){
                System.out.println("success");
                return new ResponseEntity<>(userData, HttpStatus.OK);
            }
            else{
                System.out.println("fail");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
