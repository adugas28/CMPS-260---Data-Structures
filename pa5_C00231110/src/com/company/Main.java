// Austin Dugas
// C00231110
// CMPS 260
// Programming Assignment: #5
// Due Date: Thursday, March 19, 2020
// Program Description: This program allows the user to create a virtual garden. A menu
//                      is displayed and prompts the user to select one of eight options.
//                      The user can then perform actions such as adding new plants, water
//                      the garden, and display plant details by selecting the appropriate
//                      option. The user can end the program by selecting the last option.
// Certificate of Authenticity:
// I certify that, other than the code provided ny the instructor, the code in this project is entirely
// my own work.

package com.company;

import java.util.Scanner;

public class Main {

    public static void DisplayMenu() {
        System.out.println("Welcome to your virtual garden. Please select an option:");
        System.out.println("1. Show the number of plants");
        System.out.println("2. Add a new plant");
        System.out.println("3. Add a default plant (flower, shrub, tree)");
        System.out.println("4. Increase the days the plants are watered by one");
        System.out.println("5. Water the garden");
        System.out.println("6. Show details for one plant");
        System.out.println("7. Show details for all the plants");
        System.out.println("8. Quit");
    }

    public static void main(String[] args) {

        // Ask the user for the number of plants in their garden
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of plants in your garden (minimum 3 plants): ");
        int plantNum = input.nextInt();

        // Check for bad user input
        while (plantNum < 3) {
            System.out.print("Invalid input. Enter the number of plants in your garden (minimum 3 plants): ");
            plantNum = input.nextInt();
        }

        // Create the garden object
        Garden garden = new Garden(plantNum);

        // Displays the menu
        DisplayMenu();
        System.out.print("Enter the number of the choice selected: ");
        int choice = input.nextInt();
        System.out.println();

        // Processes user input
        while (choice != 8) {
            if (choice == 1) {

                System.out.println("The number of plants in your garden is " + garden.getNumPlants() + ".");
                System.out.println();

                // Display the menu again
                DisplayMenu();
                System.out.print("Enter the number of the choice selected: ");
                choice = input.nextInt();
                System.out.println();

            } else if (choice == 2) {

                System.out.print("Enter the name of the plant: ");
                input.nextLine();
                String plantName = input.nextLine();
                System.out.print("\nEnter the height of the plant in inches: ");
                double plantHeight = input.nextDouble();
                while (plantHeight < 0) {
                    System.out.print("Invalid height. Enter the height of the plant in inches: ");
                    plantHeight = input.nextDouble();
                }
                Plant newPlant = new Plant(plantName, plantHeight);
                garden.addPlantCreated(newPlant);
                System.out.println("Your new plant was added.");
                System.out.println();

                // Display the menu again
                DisplayMenu();
                System.out.print("Enter the number of the choice selected: ");
                choice = input.nextInt();
                System.out.println();

            } else if (choice == 3) {
                System.out.println("1. Flower");
                System.out.println("2. Shrub");
                System.out.println("3. Tree");
                System.out.print("Enter the number of the plant you would like to create: ");
                int pick = input.nextInt();

                while (pick < 1 || pick > 3) {
                    System.out.print("Invalid input. Enter the number of the plant you would like to create: ");
                    pick = input.nextInt();
                }

                if (pick == 1) {
                    Plant plant = Plant.createFlower();
                    garden.addPlantCreated(plant);
                } else if (pick == 2) {
                    Plant plant = Plant.createShrub();
                    garden.addPlantCreated(plant);
                } else {
                    Plant plant = Plant.createTree();
                    garden.addPlantCreated(plant);
                }
                System.out.println("Your new plant was added.");
                System.out.println();

                // Display the menu again
                DisplayMenu();
                System.out.print("Enter the number of the choice selected: ");
                choice = input.nextInt();
                System.out.println();

            } else if (choice == 4) {
                int daysIncrease = 1;
                int newDaysNeedWater = daysIncrease + garden.getNumDaysWatered();
                garden.setNumDaysWatered(newDaysNeedWater);
                System.out.println();
                System.out.println("The number of days since the garden has been watered is now " + garden.getNumDaysWatered());
                System.out.println();

                // Display the menu again
                DisplayMenu();
                System.out.print("Enter the number of the choice selected: ");
                choice = input.nextInt();
                System.out.println();

            } else if (choice == 5) {
                garden.checkWatering();
                System.out.println();
                System.out.println("Your garden has been watered.");
                System.out.println();

                // Display the menu again
                DisplayMenu();
                System.out.print("Enter the number of the choice selected: ");
                choice = input.nextInt();
                System.out.println();

            } else if (choice == 6) {
                System.out.print("Enter the position of the plant you want to know more of: ");
                int index = input.nextInt();
                String info = garden.getInfo(index);
                System.out.println();
                System.out.println(info);
                System.out.println();

                // Display the menu again
                DisplayMenu();
                System.out.print("Enter the number of the choice selected: ");
                choice = input.nextInt();
                System.out.println();

            } else if (choice == 7) {
                System.out.println();
                garden.allInfo();
                System.out.println();

                // Display the menu again
                DisplayMenu();
                System.out.print("Enter the number of the choice selected: ");
                choice = input.nextInt();
                System.out.println();

            } else {
                System.out.println("Invalid input. Please try again.");
                System.out.println();
                DisplayMenu();
                System.out.print("Enter the number of the choice selected: ");
                choice = input.nextInt();
            }
        }
        // Close the menu
        //System.out.println();
        System.out.println("Have a nice day!");
    }
}