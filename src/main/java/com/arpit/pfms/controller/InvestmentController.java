package com.arpit.pfms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arpit.pfms.dto.InvestmentRequest;
import com.arpit.pfms.dto.InvestmentResponse;
import com.arpit.pfms.service.InvestmentService;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
@CrossOrigin(origins = "*")
public class InvestmentController {

    private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping
    public ResponseEntity<InvestmentResponse> addInvestment(@RequestBody InvestmentRequest request) {
        return ResponseEntity.ok(investmentService.addInvestment(request));
    }

    @GetMapping
    public ResponseEntity<List<InvestmentResponse>> getAllInvestments() {
        return ResponseEntity.ok(investmentService.getAllInvestments());
    }
}