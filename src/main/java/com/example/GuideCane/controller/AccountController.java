package com.example.GuideCane.controller;

import java.util.Optional;

import com.example.GuideCane.dto.LoginDTO;
import com.example.GuideCane.repository.AccountRepository;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.service.AccountService;
import com.example.GuideCane.dto.AccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO) {
        try{
            Account account = accountService.createAccount(accountDTO);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Optional<Account>> loginAccount(@RequestBody LoginDTO loginDTO) {
        try{
            Optional<Account> account = accountService.loginAccount(loginDTO);
            if(account != null){
                return new ResponseEntity<>(account, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
