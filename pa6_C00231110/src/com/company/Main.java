// Austin Dugas
// C00231110
// CMPS 260
// Programming Assignment: #6
// Due Date: Saturday, March 28, 2020
// Program Description: This program asks the user for the number of planters they want to
//                      use. Plants are randomly selected to be placed in the planters. The
//                      information about the volume of the potter and the dirt inside is
//                      displayed for each planter.
// Certificate of Authenticity:
// I certify that, other than the code provided by the instructor, the code in this project is entirely
// my own work.

package com.company;

import java.util.Scanner;

public class Main {

    public static void PlantRandomizer(Planter[] plants) {
        for (int i = 0; i < plants.length; i++) {
            double newPlant = Math.random();
            if (newPlant <= 0.33) {
                Planter newPlanter = Planter.createFlower();
                plants[i] = newPlanter;
            } else if (newPlant > 0.33 && newPlant <= 0.67) {
                Planter newPlanter = Planter.createMint();
                plants[i] = newPlanter;
            } else {
                Planter newPlanter = Planter.createFicus();
                plants[i] = newPlanter;
            }
        }
    }

    public static void PlantInfo(Planter[] plants) {
        for (int i = 0; i < plants.length; i++) {
            System.out.println("Plant: " + plants[i].getPlant() + ", " + plants[i].getPlanterSize() + " cc");
            if (plants[i].getPlanterSize() == 5) {
                System.out.println("2 parts clay     2 parts sand     3 parts other");
                System.out.println("28.57% clay      28.57% sand      42.86% other");
                System.out.println("1.43 cc clay     1.43 cc sand     2.14 cc other");
            } else if (plants[i].getPlanterSize() == 25) {
                System.out.println("1 parts clay     2 parts sand     3 parts other");
                System.out.println("16.67% clay      33.33% sand      50.00% other");
                System.out.println("4.17 cc clay     8.33 cc sand     12.50 cc other");
            } else {
                System.out.println("4 parts clay     8 parts sand     4 parts other");
                System.out.println("25.00% clay      50.00% sand      25.00% other");
                System.out.println("25.00 cc clay    50.00 cc sand    25.00 cc other");
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of planters: ");
        int planterNum = input.nextInt();
        System.out.println();

        Planter[] plants = new Planter[planterNum];
        PlantRandomizer(plants);
        PlantInfo(plants);

    }
}
