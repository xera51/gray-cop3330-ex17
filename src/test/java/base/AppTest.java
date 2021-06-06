/*
 *  UCF COP3330 Summer 2021 Exercise 17 Solution
 *  Copyright 2021 Christopher Gray
 */
package base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    static App myApp = new App();

    @Test
    public void bac_is_calculated_properly_1() {
        int gender = 1;
        int ounces = 3;
        int weight = 175;
        int hours = 1;

        String expectedOutput = String.format("%f", 0.049323);
        String actualOutput = String.format("%f", myApp.calculateBAC(gender, ounces, weight, hours));

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void bac_is_calculated_properly_2() {
        int gender = 1;
        int ounces = 5;
        int weight = 175;
        int hours = 1;

        String expectedOutput = String.format("%f", 0.092206);
        String actualOutput = String.format("%f", myApp.calculateBAC(gender, ounces, weight, hours));

        assertEquals(expectedOutput, actualOutput);
    }

}