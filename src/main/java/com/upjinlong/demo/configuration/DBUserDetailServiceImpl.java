package com.upjinlong.demo.configuration;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.upjinlong.demo.module.account.entity.Account;
import com.upjinlong.demo.module.account.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * DB Authentication
 */
@Component
public class DBUserDetailServiceImpl implements UserDetailsService {

    @Resource
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Account> query = new QueryWrapper<>();
        query.eq("acc_name", username);
        Account account = accountService.getOne(query);
        if(account == null){
            throw new UsernameNotFoundException(username);
        }
        return new User(account.getAccName(), account.getAccPassword(), Collections.emptyList());
    }
}
