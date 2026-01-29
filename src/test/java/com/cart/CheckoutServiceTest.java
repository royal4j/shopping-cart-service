package com.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutServiceTest {

    private CheckoutService checkoutService;

    @BeforeEach
    void setUp() {
        checkoutService = new CheckoutService();
    }

    @Test
    void totalForTwoApplesShouldReflectBuyOneGetOneFree() {
        List<Item> items = List.of(Item.APPLE, Item.APPLE);

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(new BigDecimal("0.60"), total);
    }

    @Test
    void totalForFourApplesShouldApplyOfferTwice() {
        List<Item> items = List.of(Item.APPLE, Item.APPLE, Item.APPLE, Item.APPLE);

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(new BigDecimal("1.20"), total);
    }

    @Test
    void totalForThreeApplesShouldApplyOfferAndChargeOne() {
        List<Item> items = List.of(Item.APPLE, Item.APPLE, Item.APPLE);

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(new BigDecimal("1.20"), total);
    }

    @Test
    void totalForThreeOrangesShouldChargeForTwoOnly() {
        List<Item> items = List.of(Item.ORANGE, Item.ORANGE, Item.ORANGE);

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(new BigDecimal("0.50"), total);
    }

    @Test
    void totalForSixOrangesShouldApplyOfferTwice() {
        List<Item> items = List.of(Item.ORANGE, Item.ORANGE, Item.ORANGE,
                Item.ORANGE, Item.ORANGE, Item.ORANGE);

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(new BigDecimal("1.00"), total);
    }

    @Test
    void totalForFiveOrangesShouldApplyOfferOnceAndChargeTwo() {
        List<Item> items = List.of(Item.ORANGE, Item.ORANGE, Item.ORANGE, Item.ORANGE, Item.ORANGE);

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(new BigDecimal("1.00"), total);
    }

    @Test
    void totalForThreeApplesAndThreeOrangesShouldApplyBothOffers() {
        List<Item> items = List.of(Item.APPLE, Item.APPLE, Item.APPLE,
                Item.ORANGE, Item.ORANGE, Item.ORANGE);

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(new BigDecimal("1.70"), total);
    }

    @Test
    void shouldReturnZeroForEmptyCart() {
        List<Item> items = List.of();

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(0, total.compareTo(BigDecimal.ZERO));
    }

}
