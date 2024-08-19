package com.upjinlong.demo.module.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.upjinlong.demo.module.account.Account;
import com.upjinlong.demo.module.account.dao.AccountMapper;
import com.upjinlong.demo.module.account.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
