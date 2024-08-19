package com.upjinlong.demo.module;

import com.upjinlong.demo.module.account.Account;
import com.upjinlong.demo.module.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirstController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String hello(){
        List<Account> list = accountService.list();
        return "ok";
    }
}
