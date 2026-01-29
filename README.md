# Shopping Cart Checkout

This project implements a simple checkout system as part of a pre-interview exercise.

The shop sells two products:

- **Apple** – £0.60  
- **Orange** – £0.25  

The checkout calculates the total price for a list of scanned items and applies the following offers:

- **Apples**: Buy one, get one free  
- **Oranges**: 3 for the price of 2  

---

## Approach

The solution was developed incrementally using a TDD-style workflow:

1. Start with a basic checkout that sums item prices  
2. Refactor input from strings to a type-safe `Item` enum  
3. Extend the existing checkout logic to apply promotional offers  

The pricing logic is written to be explicit and easy to read, prioritising clarity over clever arithmetic.

---

## Running the Tests

The project uses **Java 21** and **Gradle**.

To run the test suite:

```bash
./gradlew test
