package com.cart;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

//add logging
public class CheckoutService {

    public BigDecimal calculateTotal(List<Item> items) {
        return Arrays.stream(Item.values())
                .map(item -> {
                    long count = items.stream().filter(i -> i == item).count();
                    return calculateItemTotal(item, count);
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateItemTotal(Item item, long count) {
        return switch (item.getOffer()) {
            case BUY_ONE_GET_ONE_FREE -> item.getPrice().multiply(BigDecimal.valueOf(count / 2 + count % 2));
            case THREE_FOR_TWO -> item.getPrice().multiply(BigDecimal.valueOf((count / 3) * 2 + (count % 3)));
            case NONE -> item.getPrice().multiply(BigDecimal.valueOf(count));
        };
    }
}
