package com.spongzi.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spongzi.demo.domain.Wallet;
import com.spongzi.demo.mapper.WalletMapper;
import com.spongzi.demo.service.WalletService;
import org.springframework.stereotype.Service;

/**
* @author spongzi
* @description 针对表【wallet】的数据库操作Service实现
* @createDate 2023-08-11 11:12:21
*/
@Service
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet>
    implements WalletService {

    @Override
    public Wallet findByUserId(Integer userId) {
        LambdaQueryWrapper<Wallet> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Wallet::getUserId, userId);
        return this.getOne(queryWrapper);
    }
}




