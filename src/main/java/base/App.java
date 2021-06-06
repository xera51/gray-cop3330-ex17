/*
 *  UCF COP3330 Summer 2021 Exercise 17 Solution
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

    //TODO try to refactor to reduce repeated code in read methods
    private int readGender() {
        int d;
        while(true) {
            System.out.print("Enter a 1 is you are male or a 2 if you are female: ");
            try {
                d = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number.");
                continue;
            }
            break;
        }
        return d;
    }

    private int readNumOuncesAlcohol() {
        int d;
        while(true) {
            System.out.print("How many ounces of alcohol did you have? ");
            try {
                d = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number.");
                continue;
            }
            break;
        }
        return d;
    }

    private int readWeightPounds() {
        int d;
        while(true) {
            System.out.print("What is your weight, in pounds? ");
            try {
                d = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number.");
                continue;
            }
            break;
        }
        return d;
    }

    private int readHoursSinceDrink() {
        int d;
        while(true) {
            System.out.print("How many hours has it been since your last drink? ");
            try {
                d = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number.");
                continue;
            }
            break;
        }
        return d;
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
