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
    void shouldCalculateTotalForOnlyApples() {
        //Given
        List<Item> items = List.of(Item.APPLE, Item.APPLE);

        //When
        BigDecimal total = checkoutService.calculateTotal(items);

        //Then
        assertEquals(new BigDecimal("1.20"), total);
    }

    @Test
    void shouldCalculateTotalForOnlyOranges() {
        //Given
        List<Item> items = List.of(Item.ORANGE, Item.ORANGE, Item.ORANGE);

        //When
        BigDecimal total = checkoutService.calculateTotal(items);

        //Then
        assertEquals(new BigDecimal("0.75"), total);
    }

    @Test
    void shouldCalculateTotalForMultipleItems() {
        //Given
        List<Item> items = List.of(Item.APPLE, Item.APPLE, Item.ORANGE, Item.APPLE);

        //When
        BigDecimal total = checkoutService.calculateTotal(items);

        //Then
        assertEquals(new BigDecimal("2.05"), total);
    }

    @Test
    void shouldReturnZeroForEmptyCart() {
        //Given
        List<Item> emptyList = emptyList();

        //When
        BigDecimal total = checkoutService.calculateTotal(emptyList);

        //Then
        assertEquals(BigDecimal.ZERO, total);
    }

}
