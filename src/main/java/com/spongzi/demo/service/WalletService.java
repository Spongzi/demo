package com.spongzi.demo.service;

import com.spongzi.demo.domain.Wallet;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author spongzi
* @description 针对表【wallet】的数据库操作Service
* @createDate 2023-08-11 11:12:21
*/
public interface WalletService extends IService<Wallet> {

    /**
     * 找到用户id
     *
     * @param userId 用户id
     * @return {@link Wallet}
     */
    Wallet findByUserId(Integer userId);
}
