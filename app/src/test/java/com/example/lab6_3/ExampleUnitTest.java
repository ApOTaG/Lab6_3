
package com.example.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Calculator calculator = new Calculator();
        double result = calculator.performOperation(2, 2, "+");
        assertEquals(4, result, 0.001);
    }

    @Test
    public void subtraction_isCorrect() {
        Calculator calculator = new Calculator();
        double result = calculator.performOperation(3, 2, "-");
        assertEquals(1, result, 0.001);
    }

    @Test
    public void multiplication_isCorrect() {
        Calculator calculator = new Calculator();
        double result = calculator.performOperation(3, 2, "*");
        assertEquals(6, result, 0.001);
    }

    @Test
    public void division_isCorrect() {
        Calculator calculator = new Calculator();
        double result = calculator.performOperation(6, 3, "/");
        assertEquals(2, result, 0.001);
    }
}
