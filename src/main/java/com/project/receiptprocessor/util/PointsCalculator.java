package com.project.receiptprocessor.util;

import com.project.receiptprocessor.model.Receipt;

public class PointsCalculator {

    public static int calculatePoints(Receipt receipt) {
        int points = 0;
        points += calculateAlphanumericPoints(receipt.getRetailer());
        points += calculateRoundDollarPoints(receipt.getTotal());
        points += calculateMultipleOfQuarterPoints(receipt.getTotal());
        points += calculateItemPairPoints(receipt.getItems().size());
        points += calculateDescriptionPoints(receipt);
        points += calculateOddDayPoints(receipt.getPurchaseDate());
        points += calculateAfternoonPurchasePoints(receipt.getPurchaseTime());
        return points;
    }

    private static int calculateAlphanumericPoints(String retailer) {
        return retailer.replaceAll("[^a-zA-Z0-9]", "").length();
    }

    private static int calculateRoundDollarPoints(String total) {
        return total.matches("\\d+\\.00") ? 50 : 0;
    }

    private static int calculateMultipleOfQuarterPoints(String total) {
        return Double.parseDouble(total) % 0.25 == 0 ? 25 : 0;
    }

    private static int calculateItemPairPoints(int itemCount) {
        return (itemCount / 2) * 5;
    }

    private static int calculateDescriptionPoints(Receipt receipt) {
        return receipt.getItems().stream()
                .mapToInt(item -> {
                    String description = item.getShortDescription().trim();
                    if (description.length() % 3 == 0) {
                        double price = Double.parseDouble(item.getPrice());
                        return (int) Math.ceil(price * 0.2);
                    }
                    return 0;
                }).sum();
    }

    private static int calculateOddDayPoints(String purchaseDate) {
        int day = Integer.parseInt(purchaseDate.split("-")[2]);
        return day % 2 != 0 ? 6 : 0;
    }

    private static int calculateAfternoonPurchasePoints(String purchaseTime) {
        int hour = Integer.parseInt(purchaseTime.split(":")[0]);
        return (hour >= 14 && hour < 16) ? 10 : 0;
    }
}
