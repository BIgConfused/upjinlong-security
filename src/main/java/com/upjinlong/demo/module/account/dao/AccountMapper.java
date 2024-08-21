package com.upjinlong.demo.module.account.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.upjinlong.demo.module.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
