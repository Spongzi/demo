package com.spongzi.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spongzi.demo.domain.WalletTransaction;
import com.spongzi.demo.mapper.WalletTransactionMapper;
import com.spongzi.demo.service.WalletTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author spongzi
* @description 针对表【wallet_transaction】的数据库操作Service实现
* @createDate 2023-08-11 11:12:50
*/
@Service
public class WalletTransactionServiceImpl extends ServiceImpl<WalletTransactionMapper, WalletTransaction>
    implements WalletTransactionService {

    @Override
    public List<WalletTransaction> findByUserId(Integer userId) {
        LambdaQueryWrapper<WalletTransaction> queryWrapper = new LambdaQueryWrapper<>();
        return this.list(queryWrapper);
    }
}




