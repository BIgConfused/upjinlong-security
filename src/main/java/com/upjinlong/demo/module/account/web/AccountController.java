package com.upjinlong.demo.module.account.web;

import com.upjinlong.demo.common.http.JsonObject;
import com.upjinlong.demo.module.account.entity.Account;
import com.upjinlong.demo.module.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public JsonObject list(){
        return new JsonObject(accountService.list());
    }

    @PostMapping
    public JsonObject add(@RequestBody Account account){
        accountService.save(account);
        return JsonObject.SUCCESS;
    }

}
