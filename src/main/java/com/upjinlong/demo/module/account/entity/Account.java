package com.upjinlong.demo.module.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("account")
public class Account {

    @TableId(value = "account_id", type = IdType.AUTO)
    private Integer accountId;
    @TableField("acc_name")
    private String accName;
    @TableField("acc_password")
    private String accPassword;
    @TableField("is_enabled")
    private Integer isEnabled;
}
