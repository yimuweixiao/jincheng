package com.example.demo.service;

import com.example.demo.bean.Account;
import com.example.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public Account getAccountByName(String name){
        return accountDao.getAccountByName(name);
    }

    public Account login(String username,String password){
        return accountDao.login(username,password);
    }
}
