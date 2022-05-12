package com.example.GuideCane.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.example.GuideCane.repository.AccountRepository;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.service.AccountService;
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
@RequestMapping(value ="/account",produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    private AccountService accountService;
    DataSource dataSource;

    AccountController(){

    }
    AccountController(AccountRepository accountRepository,AccountService accountService,DataSource dataSource){
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.dataSource = dataSource;
    }
    @PostMapping
    public ResponseEntity<Account> createProduct(@RequestBody Account request) {
        Account account = accountService.createProduct(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();

        return ResponseEntity.created(location).body(account);
    }
}
