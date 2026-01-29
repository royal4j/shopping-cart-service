package com.cart;

import java.math.BigDecimal;

public enum Item {
    APPLE(new BigDecimal("0.60"), OfferType.BUY_ONE_GET_ONE_FREE),
    ORANGE(new BigDecimal("0.25"), OfferType.THREE_FOR_TWO);

    private final BigDecimal price;
    private final OfferType offer;

    Item(BigDecimal price, OfferType offer) {
        this.price = price;
        this.offer = offer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferType getOffer() {
        return offer;
    }
}
