package com.spongzi.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.spongzi.demo.domain.WalletTransaction;

import java.util.List;

/**
* @author spongzi
* @description 针对表【wallet_transaction】的数据库操作Service
* @createDate 2023-08-11 11:12:50
*/
public interface WalletTransactionService extends IService<WalletTransaction> {

    /**
     * 找到用户id
     *
     * @param userId 用户id
     * @return {@link List}<{@link WalletTransaction}>
     */
    List<WalletTransaction> findByUserId(Integer userId);
}
