package com.upjinlong.demo.module.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.upjinlong.demo.module.account.entity.Account;
import com.upjinlong.demo.module.account.dao.AccountMapper;
import com.upjinlong.demo.module.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    private final PasswordEncoder passwordEncoder;
    @Override
    public boolean save(Account entity) {
        entity.setAccPassword(passwordEncoder.encode(entity.getAccPassword()));
        return super.save(entity);
    }
}
