package com.arpit.pfms.service;

import com.arpit.pfms.entity.Invoice;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

@Service
public class PdfService {

    public String generateInvoicePdf(Invoice invoice) throws FileNotFoundException {
        String fileName = "invoices/invoice_" + invoice.getInvoiceNumber() + ".pdf";
        File file = new File(fileName);
        file.getParentFile().mkdirs();

        PdfWriter writer = new PdfWriter(fileName);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("INVOICE"));
        document.add(new Paragraph("Invoice Number: " + invoice.getInvoiceNumber()));
        document.add(new Paragraph("Customer: " + invoice.getCustomerName()));
        document.add(new Paragraph("Amount: ₹" + invoice.getAmount()));
        document.add(new Paragraph("Description: " + invoice.getDescription()));
        document.add(new Paragraph("Date: " + invoice.getCreatedAt()));

        document.close();

        return fileName;
    }
}