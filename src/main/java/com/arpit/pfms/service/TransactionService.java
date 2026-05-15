package com.arpit.pfms.service;

import org.springframework.stereotype.Service;

import com.arpit.pfms.dto.TransactionRequest;
import com.arpit.pfms.dto.TransactionResponse;
import com.arpit.pfms.entity.Transaction;
import com.arpit.pfms.entity.TransactionType;
import com.arpit.pfms.entity.User;
import com.arpit.pfms.repository.TransactionRepository;
import com.arpit.pfms.util.CurrentUser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CurrentUser currentUser;

    public TransactionService(TransactionRepository transactionRepository, CurrentUser currentUser) {
        this.transactionRepository = transactionRepository;
        this.currentUser = currentUser;
    }

    public TransactionResponse addTransaction(TransactionRequest request) {
        User user = currentUser.getCurrentUser();

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setAmount(request.getAmount());
        transaction.setType(request.getType());
        transaction.setCategory(request.getCategory());
        transaction.setDescription(request.getDescription());
        transaction.setMerchant(request.getMerchant());
        transaction.setTransactionDate(request.getTransactionDate() != null ? 
                request.getTransactionDate() : LocalDateTime.now());

        Transaction saved = transactionRepository.save(transaction);

        return mapToResponse(saved);
    }

    public List<TransactionResponse> getAllTransactions() {
        User user = currentUser.getCurrentUser();
        List<Transaction> transactions = transactionRepository.findByUserOrderByTransactionDateDesc(user);
        return transactions.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public List<TransactionResponse> getTransactionsByType(TransactionType type) {
        User user = currentUser.getCurrentUser();
        List<Transaction> transactions = transactionRepository.findByUserAndTypeOrderByTransactionDateDesc(user, type);
        return transactions.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private TransactionResponse mapToResponse(Transaction transaction) {
        return new TransactionResponse(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getCategory(),
                transaction.getDescription(),
                transaction.getMerchant(),
                transaction.getTransactionDate()
        );
    }
}