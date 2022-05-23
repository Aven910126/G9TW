package com.example.GuideCane.service;
import com.example.GuideCane.dto.AccountDTO;
import com.example.GuideCane.dto.LoginDTO;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account createAccount(AccountDTO accountDTO){
        String username=accountDTO.getUsername();
        String password=passwordEncoder.encode(accountDTO.getPassword());
        long devicecode=accountDTO.getDeviceCode();
        Optional<Account> _devicecode = accountRepository.findById(devicecode);
        System.out.println(_devicecode);
        if(_devicecode.isPresent()){
            return null;
        }else{
            Account account = accountRepository.save(new Account(devicecode,username,password));
            return account;
        }
    }
    public Optional<Account> loginAccount(LoginDTO loginDTO){
        long deviceCode=loginDTO.getDeviceCode();
        String password=loginDTO.getPassword();
        Optional<Account> userData = accountRepository.findById(deviceCode);
        long _deviceCode = userData.get().getDeviceCode();
        String _password = userData.get().getPassword();;
        if(deviceCode == _deviceCode && passwordEncoder.matches(password,_password)){
            return userData;
        }else{
            return null;
        }
    }
}
