package com.cart;

import java.math.BigDecimal;
import java.util.List;

//add logging
public class CheckoutService {

    public BigDecimal calculateTotal(List<Item> items) {
        return items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
