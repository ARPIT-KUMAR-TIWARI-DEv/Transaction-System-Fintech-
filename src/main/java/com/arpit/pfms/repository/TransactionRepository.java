package com.arpit.pfms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpit.pfms.entity.Transaction;
import com.arpit.pfms.entity.TransactionType;
import com.arpit.pfms.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserOrderByTransactionDateDesc(User user);

    List<Transaction> findByUserAndTypeOrderByTransactionDateDesc(User user, TransactionType type);

    List<Transaction> findByUserAndTransactionDateBetween(User user, LocalDateTime start, LocalDateTime end);
}