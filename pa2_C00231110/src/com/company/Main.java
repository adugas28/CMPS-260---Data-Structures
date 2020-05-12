// Austin Dugas
// C00231110
// CMPS 260
// Programming Assignment: 2
// Due Date: Tuesday, February 4, 2020
// Program Description: This program asks the user to input integers for the number
//                      of at-bats and hits for a baseball player then calculates the
//                      batting average for that player. The program then determines if
//                      the player qualifies for the All Stars game based on the batting
//                      average.
//
// I certify that the code in the method function main of this project is entirely my own
// work.

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of at-bats: ");
        double atBats = input.nextInt();
        System.out.print("Enter the number of hits: ");
        double hits = input.nextInt();

        if (atBats < 0 || hits < 0) {
            System.out.println("Invalid inputs entered");
        } else if (atBats == 0) {
            System.out.println("Invalid inputs entered");
        } else if (atBats < hits) {
            System.out.println("Invalid inputs entered");
        } else {
            double batAvg;
            batAvg = (hits / atBats);

            System.out.printf("Hitting percentage: %5.3f", batAvg);
            System.out.println();

            if (batAvg > .300) {
                System.out.println("Eligible for All Stars game");
            } else {
                System.out.println("Ineligible for All Stars game");
            }
        }

    }
}
