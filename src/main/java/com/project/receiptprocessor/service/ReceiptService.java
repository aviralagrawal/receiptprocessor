package com.project.receiptprocessor.service;

import com.project.receiptprocessor.model.Receipt;
import com.project.receiptprocessor.util.PointsCalculator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ReceiptService {

    private final Map<String, Receipt> receiptStore = new HashMap<>();

    public String processReceipt(Receipt receipt) {
        String id = UUID.randomUUID().toString();
        receipt.setId(id);
        int points = PointsCalculator.calculatePoints(receipt);
        receipt.setPoints(points);
        receiptStore.put(id, receipt);
        return id;
    }

    public Integer getPoints(String id) {
        Receipt receipt = receiptStore.get(id);
        return receipt != null ? receipt.getPoints() : null;
    }
}

