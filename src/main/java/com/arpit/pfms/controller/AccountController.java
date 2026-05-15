package com.arpit.pfms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arpit.pfms.entity.Account;
import com.arpit.pfms.entity.User;
import com.arpit.pfms.util.AesEncryptionUtil;
import com.arpit.pfms.util.CurrentUser;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*")
public class AccountController {

    private final CurrentUser currentUser;
    private final AesEncryptionUtil aesEncryptionUtil;

    public AccountController(CurrentUser currentUser, AesEncryptionUtil aesEncryptionUtil) {
        this.currentUser = currentUser;
        this.aesEncryptionUtil = aesEncryptionUtil;
    }

    @PostMapping
    public ResponseEntity<?> linkAccount(@RequestBody Map<String, String> request) {
        User user = currentUser.getCurrentUser();

        Account account = new Account();
        account.setUser(user);
        account.setBankName(request.get("bankName"));
        account.setAccountNumber(aesEncryptionUtil.encrypt(request.get("accountNumber")));
        account.setIfscCode(request.get("ifscCode"));
        account.setAccountType(request.get("accountType"));
        account.setUpiId(request.get("upiId"));

        // In real project, save to DB. Here returning mock response
        Map<String, String> response = new HashMap<>();
        response.put("message", "Bank Account Linked Successfully");
        response.put("upiId", account.getUpiId());
        response.put("status", "SUCCESS");

        return ResponseEntity.ok(response);
    }
}