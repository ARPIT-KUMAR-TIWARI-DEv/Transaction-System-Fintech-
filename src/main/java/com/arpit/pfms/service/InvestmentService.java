package com.arpit.pfms.service;

import org.springframework.stereotype.Service;

import com.arpit.pfms.dto.InvestmentRequest;
import com.arpit.pfms.dto.InvestmentResponse;
import com.arpit.pfms.entity.Investment;
import com.arpit.pfms.entity.User;
import com.arpit.pfms.repository.InvestmentRepository;
import com.arpit.pfms.util.CurrentUser;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final CurrentUser currentUser;

    public InvestmentService(InvestmentRepository investmentRepository, CurrentUser currentUser) {
        this.investmentRepository = investmentRepository;
        this.currentUser = currentUser;
    }

    public InvestmentResponse addInvestment(InvestmentRequest request) {
        User user = currentUser.getCurrentUser();

        Investment investment = new Investment();
        investment.setUser(user);
        investment.setAssetType(request.getAssetType());
        investment.setSymbol(request.getSymbol());
        investment.setQuantity(request.getQuantity());
        investment.setBuyPrice(request.getBuyPrice());
        investment.setCurrentPrice(request.getBuyPrice()); // Mock current price
        investment.setPurchaseDate(LocalDateTime.now());
        investment.setLastUpdated(LocalDateTime.now());

        Investment saved = investmentRepository.save(investment);
        return mapToResponse(saved);
    }

    public List<InvestmentResponse> getAllInvestments() {
        User user = currentUser.getCurrentUser();
        List<Investment> investments = investmentRepository.findByUser(user);
        return investments.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private InvestmentResponse mapToResponse(Investment inv) {
        BigDecimal totalValue = inv.getCurrentPrice().multiply(inv.getQuantity());
        BigDecimal profitLoss = totalValue.subtract(inv.getBuyPrice().multiply(inv.getQuantity()));
        double percentage = inv.getBuyPrice().compareTo(BigDecimal.ZERO) > 0 ?
                profitLoss.divide(inv.getBuyPrice().multiply(inv.getQuantity()), 4, BigDecimal.ROUND_HALF_UP).doubleValue() * 100 : 0;

        return new InvestmentResponse(
                inv.getId(),
                inv.getAssetType(),
                inv.getSymbol(),
                inv.getQuantity(),
                inv.getBuyPrice(),
                inv.getCurrentPrice(),
                totalValue,
                profitLoss,
                percentage
        );
    }
}