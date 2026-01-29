package com.cart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//add logging
public class CheckoutService {

    public BigDecimal calculateTotal(List<Item> items) {
        final Map<Item, Long> itemCounts = items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        final BigDecimal appleTotal = calculateAppleTotal(itemCounts.getOrDefault(Item.APPLE, 0L));
        final BigDecimal orangeTotal = calculateOrangeTotal(itemCounts.getOrDefault(Item.ORANGE, 0L));

        return appleTotal.add(orangeTotal);
    }

    private BigDecimal calculateAppleTotal(long quantity) {
        long pairs = quantity / 2;
        long singles = quantity % 2;
        long payableApples = pairs + singles;

        return Item.APPLE.getPrice().multiply(BigDecimal.valueOf(payableApples));
    }

    private BigDecimal calculateOrangeTotal(long quantity) {
        long setsOfThree = quantity / 3;
        long remainder = quantity % 3;
        long payableOranges = (setsOfThree * 2) + remainder;

        return Item.ORANGE.getPrice().multiply(BigDecimal.valueOf(payableOranges));
    }

}
