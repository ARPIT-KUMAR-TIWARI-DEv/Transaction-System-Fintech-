package com.arpit.pfms.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AiCategorizationService {

    private final List<String> foodKeywords = Arrays.asList("swiggy", "zomato", "hotel", "restaurant", "food", "chai", "tea", "lunch", "dinner");
    private final List<String> transportKeywords = Arrays.asList("ola", "uber", "auto", "rickshaw", "petrol", "metro", "bus", "train");
    private final List<String> shoppingKeywords = Arrays.asList("amazon", "flipkart", "myntra", "shopping", "clothes");

    public String categorizeTransaction(String description, String merchant) {
        String text = (description + " " + merchant).toLowerCase();

        if (foodKeywords.stream().anyMatch(text::contains)) return "Food & Dining";
        if (transportKeywords.stream().anyMatch(text::contains)) return "Transportation";
        if (shoppingKeywords.stream().anyMatch(text::contains)) return "Shopping";
        if (text.contains("salary") || text.contains("credit")) return "Salary";
        if (text.contains("rent")) return "Rent";
        if (text.contains("electricity") || text.contains("bill")) return "Utilities";

        // Default category
        return "Miscellaneous";
    }
}