/*
 *  UCF COP3330 Summer 2021 Exercise 16 Solution
 *  Copyright 2021 Christopher Gray
 */
package base;

import java.util.Scanner;

public class App {

    static Scanner in = new Scanner(System.in);
    static final double MALE_RATIO = 0.73;
    static final double FEMALE_RATIO = 0.66;

    public static void main(String[] args) {
        App myApp = new App();

        int gender = myApp.readGender();
        int numOunces = myApp.readNumOuncesAlcohol();
        int weight = myApp.readWeightPounds();
        int hoursSince = myApp.readHoursSinceDrink();

        double bac = myApp.calculateBAC(gender, numOunces, weight, hoursSince);
        myApp.displayOutput(bac);
    }

    private int readGender() {
        System.out.print("Enter a 1 is you are male or a 2 if you are female: ");
        return Integer.parseInt(in.nextLine());
    }

    private int readNumOuncesAlcohol() {
        System.out.print("How many ounces of alcohol did you have? ");
        return Integer.parseInt(in.nextLine());
    }

    private int readWeightPounds() {
        System.out.print("What is your weight, in pounds? ");
        return Integer.parseInt(in.nextLine());
    }

    private int readHoursSinceDrink() {
        System.out.print("How many hours has it been since your last drink? ");
        return Integer.parseInt(in.nextLine());
    }

    public double calculateBAC(int gender, int ounceAlcohol,
                                int weightPounds, int hoursSinceDrink) {
        if(gender == 1) {
            return (ounceAlcohol * 5.14 / weightPounds * MALE_RATIO) - (0.015 * hoursSinceDrink);
        } else {
            return (ounceAlcohol * 5.14 / weightPounds * FEMALE_RATIO) - (0.015 * hoursSinceDrink);
        }
    }

    private void displayOutput(double bac) {
        System.out.printf("Your BAC is %f%n", bac);
        if(bac > 0.08) {
            System.out.println("It is not legal for you to drive.");
        } else {
            System.out.println("It is legal for you to drive.");
        }
    }
}
