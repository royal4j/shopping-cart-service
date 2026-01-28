package com.cart;

import java.math.BigDecimal;

public enum Item {
    APPLE(new BigDecimal("0.60")),
    ORANGE(new BigDecimal("0.25"));

    private final BigDecimal price;

    Item(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
