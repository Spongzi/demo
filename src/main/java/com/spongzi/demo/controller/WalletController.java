package com.spongzi.demo.controller;

import com.spongzi.demo.common.exception.DemoException;
import com.spongzi.demo.domain.Wallet;
import com.spongzi.demo.domain.WalletTransaction;
import com.spongzi.demo.domain.req.UserRefundReq;
import com.spongzi.demo.domain.req.UserSpendReq;
import com.spongzi.demo.service.WalletService;
import com.spongzi.demo.service.WalletTransactionService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.spongzi.demo.common.constant.WalletConstant.CONSUME;
import static com.spongzi.demo.common.constant.WalletConstant.REFUND;
import static com.spongzi.demo.common.exception.DemoExceptionEnum.INSUFFICIENT_BALANCE;
import static com.spongzi.demo.common.exception.DemoExceptionEnum.USER_NOT_EXIST;

@RestController
@RequestMapping("/api")
public class WalletController {
    @Resource
    private WalletService walletService;

    @Resource
    private WalletTransactionService walletTransactionService;


    /**
     * 获取余额
     *
     * @param userId 用户id
     * @return {@link ResponseEntity}<{@link ?}>
     */
    @GetMapping("/balance/{userId}")
    public ResponseEntity<?> getBalance(@PathVariable Integer userId) {
        Wallet wallet = walletService.findByUserId(userId);
        if (wallet == null) {
            throw new DemoException(USER_NOT_EXIST);
        }
        return ResponseEntity.ok(wallet.getBalance());
    }

    /**
     * 消费
     *
     * @param userSpendReq 用户消费请求参数
     * @return {@link ResponseEntity}<{@link ?}>
     */
    @PostMapping("/spend")
    @Transactional
    public ResponseEntity<?> spend(@RequestBody UserSpendReq userSpendReq) {
        // 先取出数据
        Integer userId = userSpendReq.getUserId();
        BigDecimal amount = new BigDecimal(userSpendReq.getAmount());
        // 查找当前用户是有钱包，如果有进行，如果没有或者余额不足，直接返回
        Wallet wallet = walletService.findByUserId(userId);
        if (wallet == null) {
            throw new DemoException(USER_NOT_EXIST);
        }
        if (wallet.getBalance().compareTo(amount) < 0) {
            throw new DemoException(INSUFFICIENT_BALANCE);
        }
        // 设置消费之后的金钱数量
        wallet.setBalance(wallet.getBalance().subtract(amount));
        WalletTransaction transaction = new WalletTransaction();
        transaction.setUserId(userId);
        transaction.setAmount(amount);
        transaction.setType(CONSUME);
        // 保存交易信息
        walletTransactionService.save(transaction);
        // 更新余额
        walletService.updateById(wallet);
        return ResponseEntity.ok().body("交易成功");
    }

    /**
     * 退款
     *
     * @param userRefundReq 用户退款申请
     * @return {@link ResponseEntity}<{@link ?}>
     */
    @PostMapping("/refund")
    @Transactional
    public ResponseEntity<?> refund(@RequestBody UserRefundReq userRefundReq) {
        // 先取出数据
        Integer userId = userRefundReq.getUserId();
        BigDecimal amount = new BigDecimal(userRefundReq.getAmount());
        // 查找当前用户是否存在
        Wallet wallet = walletService.findByUserId(userId);
        if (wallet == null) {
            throw new DemoException(USER_NOT_EXIST);
        }
        // 设置相关数据
        wallet.setBalance(wallet.getBalance().add(amount));
        WalletTransaction transaction = new WalletTransaction();
        transaction.setUserId(userId);
        transaction.setAmount(amount);
        transaction.setType(REFUND);
        // 保存交易信息
        walletTransactionService.save(transaction);
        // 更新钱包金额
        walletService.updateById(wallet);
        return ResponseEntity.ok().body("退款成功");
    }

    /**
     * 查询用户钱包金额变动明细的接口
     *
     * @param userId 用户id
     * @return {@link ResponseEntity}<{@link ?}>
     */
    @GetMapping("/transactions")
    public ResponseEntity<?> getTransactions(@RequestParam Integer userId) {
        List<WalletTransaction> transactions = walletTransactionService.findByUserId(userId);
        return ResponseEntity.ok(transactions);
    }
}
