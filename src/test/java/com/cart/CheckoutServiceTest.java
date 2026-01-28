package com.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckoutServiceTest {

    private CheckoutService checkoutService;

    @BeforeEach
    void setUp() {
        checkoutService = new CheckoutService();
    }

    @Test
    void shouldCalculateTotalForOnlyApples() {
        List<String> items = List.of("Apple", "Apple");

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(new BigDecimal("1.20"), total);
    }

    @Test
    void shouldCalculateTotalForOnlyOranges() {
        List<String> items = List.of("Orange", "Orange", "Orange");

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(new BigDecimal("0.75"), total);
    }

    @Test
    void shouldCalculateTotalForMultipleItems() {
        List<String> items = List.of("Apple", "Apple", "Orange", "Apple");

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(new BigDecimal("2.05"), total);
    }

    @Test
    void shouldReturnZeroForEmptyCart() {
        CheckoutService checkoutService = new CheckoutService();
        List<String> items = List.of();

        BigDecimal total = checkoutService.calculateTotal(items);

        assertEquals(BigDecimal.ZERO, total);
    }

    @Test
    void shouldThrowExceptionForUnknownItem() {
        List<String> items = List.of("Apple", "Banana");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkoutService.calculateTotal(items)
        );

        assertEquals("Unknown item: Banana", exception.getMessage());
    }
}
