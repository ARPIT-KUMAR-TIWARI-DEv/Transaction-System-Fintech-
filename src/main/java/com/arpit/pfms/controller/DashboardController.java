package com.arpit.pfms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arpit.pfms.dto.*;
import com.arpit.pfms.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    private final TransactionService transactionService;
    private final BudgetService budgetService;
    private final InvestmentService investmentService;

    public DashboardController(TransactionService transactionService, 
                              BudgetService budgetService, 
                              InvestmentService investmentService) {
        this.transactionService = transactionService;
        this.budgetService = budgetService;
        this.investmentService = investmentService;
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getDashboardSummary() {
        Map<String, Object> summary = new HashMap<>();
        
        summary.put("transactions", transactionService.getAllTransactions());
        summary.put("budgets", budgetService.getAllBudgets());
        summary.put("investments", investmentService.getAllInvestments());
        summary.put("totalTransactions", transactionService.getAllTransactions().size());

        return ResponseEntity.ok(summary);
    }
}