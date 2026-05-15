package com.arpit.pfms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arpit.pfms.entity.Invoice;
import com.arpit.pfms.entity.User;
import com.arpit.pfms.service.PdfService;
import com.arpit.pfms.util.CurrentUser;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {

    private final CurrentUser currentUser;
    private final PdfService pdfService;

    public InvoiceController(CurrentUser currentUser, PdfService pdfService) {
        this.currentUser = currentUser;
        this.pdfService = pdfService;
    }

    @PostMapping
    public ResponseEntity<?> createInvoice(@RequestBody Map<String, Object> request) {
        User user = currentUser.getCurrentUser();

        Invoice invoice = new Invoice();
        invoice.setUser(user);
        invoice.setInvoiceNumber("INV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        invoice.setCustomerName((String) request.get("customerName"));
        invoice.setCustomerEmail((String) request.get("customerEmail"));
        invoice.setAmount(new java.math.BigDecimal(request.get("amount").toString()));
        invoice.setDescription((String) request.get("description"));
        invoice.setStatus("PENDING");
        invoice.setCreatedAt(LocalDateTime.now());

        // In real project, save to repository first

        try {
            String pdfPath = pdfService.generateInvoicePdf(invoice);
            invoice.setPdfPath(pdfPath);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Invoice Generated Successfully");
            response.put("invoiceNumber", invoice.getInvoiceNumber());
            response.put("pdfPath", pdfPath);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error generating PDF");
        }
    }
}