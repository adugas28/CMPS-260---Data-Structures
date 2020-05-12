// Austin Dugas
// C00231110
// CMPS 260
// Programming Assignment: 1
// Due Date: Thursday, January 30, 2020
// Program Description: This program converts user inputted weight and height
//                      from inches and pounds to centimeters and kilograms,
//                      respectively.
// I certify that the code in the method function main of this project is entirely my own
// work.

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        double weight;
        double height;

        System.out.print("Enter your height in inches: ");
        height = input.nextDouble();
        System.out.print("Enter your weight in pounds: ");
        weight = input.nextDouble();

        double newHeight = height * 2.54;
        double newWeight = weight * 0.453592;

        System.out.printf("You are %5.1f centimeters tall and weigh %4.1f kilograms.", newHeight, newWeight);

    }
}
