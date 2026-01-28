package com.cart;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutService {

    private static final BigDecimal APPLE_PRICE = new BigDecimal("0.60");
    private static final BigDecimal ORANGE_PRICE = new BigDecimal("0.25");

    public BigDecimal calculateTotal(List<String> items) {
        BigDecimal total = BigDecimal.ZERO;

        for (String item : items) {
            switch (item.trim().toLowerCase()) {
                case "apple" -> total = total.add(APPLE_PRICE);
                case "orange" -> total = total.add(ORANGE_PRICE);
                default -> throw new IllegalArgumentException("Unknown item: " + item);
            }
        }

        return total;
    }
}
