package com.arpit.pfms.service;

import org.springframework.stereotype.Service;

import com.arpit.pfms.dto.BudgetRequest;
import com.arpit.pfms.dto.BudgetResponse;
import com.arpit.pfms.entity.Budget;
import com.arpit.pfms.entity.User;
import com.arpit.pfms.repository.BudgetRepository;
import com.arpit.pfms.util.CurrentUser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final CurrentUser currentUser;
    private final TransactionService transactionService;

    public BudgetService(BudgetRepository budgetRepository, CurrentUser currentUser, 
                        TransactionService transactionService) {
        this.budgetRepository = budgetRepository;
        this.currentUser = currentUser;
        this.transactionService = transactionService;
    }

    public BudgetResponse createBudget(BudgetRequest request) {
        User user = currentUser.getCurrentUser();

        Budget budget = new Budget();
        budget.setUser(user);
        budget.setCategory(request.getCategory());
        budget.setAmount(request.getAmount());
        budget.setStartDate(request.getStartDate());
        budget.setEndDate(request.getEndDate());

        Budget saved = budgetRepository.save(budget);
        return mapToResponse(saved);
    }

    public List<BudgetResponse> getAllBudgets() {
        User user = currentUser.getCurrentUser();
        List<Budget> budgets = budgetRepository.findByUser(user);
        return budgets.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private BudgetResponse mapToResponse(Budget budget) {
        // For now, spentAmount is 0. We'll improve it later with real calculation
        BigDecimal spent = BigDecimal.ZERO;
        BigDecimal remaining = budget.getAmount().subtract(spent);
        double percentage = budget.getAmount().compareTo(BigDecimal.ZERO) > 0 ?
                spent.divide(budget.getAmount(), 2, BigDecimal.ROUND_HALF_UP).doubleValue() * 100 : 0;

        return new BudgetResponse(
                budget.getId(),
                budget.getCategory(),
                budget.getAmount(),
                spent,
                remaining,
                budget.getStartDate(),
                budget.getEndDate(),
                percentage
        );
    }
}