// Austin Dugas
// C00231110
// CMPS 260
// Programming Assignment: #4
// Due Date: Thursday, March 5, 2020
// Program Description: This program will ask the user for the amount
//                      of three different types of dirt in grams for
//                      different sample sizes. The class DirtSample
//                      will initialize the three types of dirt as
//                      well as calculate the total weight and
//                      percentage of each dirt type in a sample.
// Certificate of Authenticity:
// I certify that the code in this project is entirely my own work.

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //The first sample is hard coded to test the constructor
        DirtSample sample1 = new DirtSample(3.6, 7.8, 9.15);
        System.out.println("Sample 1 Information:");
        System.out.println(sample1.getSand() + " grams of sand");
        System.out.println(sample1.getClay() + " grams of clay");
        System.out.println(sample1.getOther() + " grams of other");
        System.out.println("The total weight of the sample is " + sample1.totalWeight() + " grams.");
        System.out.printf("%.2f percent of the sample is sand.", sample1.percentSand());
        System.out.printf("\n%.2f percent of the sample is clay.", sample1.percentClay());
        System.out.printf("\n%.2f percent of the sample is other.", sample1.percentOther());
        System.out.println("\n");

        //The second sample asks the user to enter their own values. These values will be passed through the constructor.
        java.util.Scanner input = new Scanner(System.in);
        System.out.print("Enter the weight of sand in grams: ");
        double a = input.nextDouble();
        System.out.print("Enter the weight of clay in grams: ");
        double b = input.nextDouble();
        System.out.print("Enter the weight of other in grams: ");
        double c = input.nextDouble();
        DirtSample sample2 = new DirtSample(a,b,c);
        System.out.println("Sample 2 Information:");
        System.out.println(sample2.getSand() + " grams of sand");
        System.out.println(sample2.getClay() + " grams of clay");
        System.out.println(sample2.getOther() + " grams of other");
        System.out.println("The total weight of the sample is " + sample2.totalWeight() + " grams.");
        System.out.printf("%.2f percent of the sample is sand.", sample2.percentSand());
        System.out.printf("\n%.2f percent of the sample is clay.", sample2.percentClay());
        System.out.printf("\n%.2f percent of the sample is other.", sample2.percentOther());
        System.out.println("\n");

        //The third sample asks the user to enter their own values. These values will use the setters.
        System.out.print("Enter the weight of sand in grams: ");
        double x = input.nextDouble();
        System.out.print("Enter the weight of clay in grams: ");
        double y = input.nextDouble();
        System.out.print("Enter the weight of other in grams: ");
        double z = input.nextDouble();
        DirtSample sample3 = new DirtSample();
        sample3.setSand(x);
        sample3.setClay(y);
        sample3.setOther(z);
        System.out.println("Sample 2 Information:");
        System.out.println(sample3.getSand() + " grams of sand");
        System.out.println(sample3.getClay() + " grams of clay");
        System.out.println(sample3.getOther() + " grams of other");
        System.out.println("The total weight of the sample is " + sample3.totalWeight() + " grams.");
        System.out.printf("%.2f percent of the sample is sand.", sample3.percentSand());
        System.out.printf("\n%.2f percent of the sample is clay.", sample3.percentClay());
        System.out.printf("\n%.2f percent of the sample is other.", sample3.percentOther());

    }
}
