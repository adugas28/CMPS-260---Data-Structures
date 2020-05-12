// Austin Dugas
// C00231110
// CMPS 260
// Programming Assignment: #7
// Due Date: Friday, April 24, 2020
// Program Descrpition: This program simulates an inventory for a store and a shopping basket for a
//                      customer. The program creates an array list and stores information of items
//                      read from a file. The program then displays a menu asking if the user wants
//                      to add an item, remove an item, or check out. Added items go to a separate
//                      array, removed items go back to the original list, and checking out prints
//                      the number of items and total cost. This process can be repeated after
//                      checking out.
// Certificate of Authenticity:
// I certify that, other than the code provided by the instructor, the code in this project is entirely
// my own work.

package com.company;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void SavePoints(File f) {
        try(PrintWriter pw = new PrintWriter(f)) {

            for(int i = 0; i < 5; i++) {
                if (i == 0) {
                    String name = "Bread";
                    double price = 2.99;
                    int quantity = 25;
                    pw.println(name);
                    pw.println(price);
                    pw.println(quantity);
                } else if (i == 1) {
                    String name = "Milk";
                    double price = 3.49;
                    int quantity = 10;
                    pw.println(name);
                    pw.println(price);
                    pw.println(quantity);
                } else if (i == 2) {
                    String name = "Water";
                    double price = 1.09;
                    int quantity = 50;
                    pw.println(name);
                    pw.println(price);
                    pw.println(quantity);
                } else if (i == 3) {
                    String name = "Eggs";
                    double price = 3.99;
                    int quantity = 30;
                    pw.println(name);
                    pw.println(price);
                    pw.println(quantity);
                } else {
                    String name = "Cheese";
                    double price = 2.39;
                    int quantity = 35;
                    pw.println(name);
                    pw.println(price);
                    pw.println(quantity);
                }
            }

        } catch (Exception e) {
            System.out.println("File input error");
            e.printStackTrace();
        }
    }

    public static void ReadPoints(File f, ArrayList<Item> items) {
        try (Scanner reader = new Scanner(f)) {

            while(reader.hasNext()) {
                String name = reader.next();
                double price = reader.nextDouble();
                int quantity = reader.nextInt();

                Item item = new Item(name, price, quantity);
                items.add(item);
            }

        } catch (Exception e) {
            System.out.println("File input error");
            e.printStackTrace();
        }
    }

    public static void DisplayMenu(ArrayList<Item> items) {
        System.out.println("Welcome to the store! Here is our inventory list:");
        System.out.println();
        for (Item a : items) {
            System.out.println(a.getName() + " - $" + a.getPrice() + " - " + a.getQuantity());
        }
        System.out.println();
        System.out.println("Please make a selection:");
        System.out.println("1. Add an item to your cart");
        System.out.println("2. Remove an item from your cart");
        System.out.println("3. Check out");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String filename = "inventory.txt";
        File file = new File(filename);
        SavePoints(file);

        ArrayList<Item> items = new ArrayList<>();
        ReadPoints(file, items);

        ArrayList<Item> cart = new ArrayList<>();

        DisplayMenu(items);
        System.out.print("Enter your selection: ");
        int choice = input.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.println("Invalid selection. Please try again.");
            System.out.println();
            DisplayMenu(items);
            System.out.print("Enter your selection: ");
            choice = input.nextInt();
        }

        while (choice != 3) {
            if (choice == 1) {
                System.out.println();
                System.out.println("Please select an item to add to your cart:");
                int i = 1;
                for (Item a : items) {
                    System.out.println(i + ". " + a.getName() + " - $" + a.getPrice() + " - " + a.getQuantity());
                    i++;
                }
                System.out.print("Enter your selection: ");
                int addChoice = input.nextInt();
                System.out.println();

                if (addChoice == 1) {
                    System.out.print("How many? ");
                    int quantity = input.nextInt();
                    cart.add(new Item("Bread", 2.99, quantity));
                } else if (addChoice == 2) {
                    System.out.print("How many? ");
                    int quantity = input.nextInt();
                    cart.add(new Item("Milk", 3.49, quantity));
                } else if (addChoice == 3) {
                    System.out.print("How many? ");
                    int quantity = input.nextInt();
                    cart.add(new Item("Water", 1.09, quantity));
                } else if (addChoice == 4) {
                    System.out.print("How many? ");
                    int quantity = input.nextInt();
                    cart.add(new Item("Eggs", 3.99, quantity));
                } else {
                    System.out.print("How many? ");
                    int quantity = input.nextInt();
                    cart.add(new Item("Cheese", 2.39, quantity));
                }
                System.out.println("Your item(s) have been added to your cart.");

                DisplayMenu(items);
                System.out.print("Enter your selection: ");
                choice = input.nextInt();

                while (choice < 1 || choice > 3) {
                    System.out.println("Invalid selection. Please try again.");
                    System.out.println();
                    DisplayMenu(items);
                    System.out.print("Enter your selection: ");
                    choice = input.nextInt();
                }
            } else {
                System.out.println();
                int i = 1;
                for (Item a : cart) {
                    System.out.println(i + ". " + a.getName() + " - $" + a.getPrice() + " - " + a.getQuantity());
                    i++;
                }
                System.out.print("Please select an item to remove from your cart:");
                int remove = input.nextInt();
                for (Item a : cart) {
                    for (i = 0; i < remove; i++) {
                        if (remove - 1 == i) {
                            a.setQuantity(0);
                        }
                    }
                }
                System.out.println("The item has been removed from your cart.");

                DisplayMenu(items);
                System.out.print("Enter your selection: ");
                choice = input.nextInt();

                while (choice < 1 || choice > 3) {
                    System.out.println("Invalid selection. Please try again.");
                    System.out.println();
                    DisplayMenu(items);
                    System.out.print("Enter your selection: ");
                    choice = input.nextInt();
                }
            }
        }

        if (choice == 3) {
            System.out.println();
            System.out.println("Here is your receipt.");
            System.out.println();
            double sum = 0;
            for (Item a : cart) {
                System.out.println(a.getName() + " - " + a.getQuantity() + " - $" + (a.getQuantity() * a.getPrice()));
                sum += (a.getQuantity() * a.getPrice());
            }
            System.out.println();
            System.out.println("Total: $" + sum);
            System.out.println();
            System.out.println("Thank you for shopping wih us! Is there another customer who would like to shop here?");
            System.out.print("Enter a selection (1. Yes/ 2. No): ");
            int newChoice = input.nextInt();

            while (newChoice < 1 || newChoice > 2) {
                System.out.println("Invalid selection. Please try again.");
                System.out.print("\nEnter a selection (1. Yes/ 2. No): ");
                newChoice = input.nextInt();
            }

            while (newChoice == 1) {
                DisplayMenu(items);
                System.out.print("Enter your selection: ");
                choice = input.nextInt();

                while (choice < 1 || choice > 3) {
                    System.out.println("Invalid selection. Please try again.");
                    System.out.println();
                    DisplayMenu(items);
                    System.out.print("Enter your selection: ");
                    choice = input.nextInt();
                }

                while (choice != 3) {
                    if (choice == 1) {
                        System.out.println();
                        System.out.println("Please select an item to add to your cart:");
                        int i = 1;
                        for (Item a : items) {
                            System.out.println(i + ". " + a.getName() + " - $" + a.getPrice() + " - " + a.getQuantity());
                            i++;
                        }
                        System.out.print("Enter your selection: ");
                        int addChoice = input.nextInt();
                        System.out.println();

                        if (addChoice == 1) {
                            System.out.print("How many? ");
                            int quantity = input.nextInt();
                            cart.add(new Item("Bread", 2.99, quantity));
                        } else if (addChoice == 2) {
                            System.out.print("How many? ");
                            int quantity = input.nextInt();
                            cart.add(new Item("Milk", 3.49, quantity));
                        } else if (addChoice == 3) {
                            System.out.print("How many? ");
                            int quantity = input.nextInt();
                            cart.add(new Item("Water", 1.09, quantity));
                        } else if (addChoice == 4) {
                            System.out.print("How many? ");
                            int quantity = input.nextInt();
                            cart.add(new Item("Eggs", 3.99, quantity));
                        } else {
                            System.out.print("How many? ");
                            int quantity = input.nextInt();
                            cart.add(new Item("Cheese", 2.39, quantity));
                        }
                        System.out.println("Your item(s) have been added to your cart.");

                        DisplayMenu(items);
                        System.out.print("Enter your selection: ");
                        choice = input.nextInt();

                        while (choice < 1 || choice > 3) {
                            System.out.println("Invalid selection. Please try again.");
                            System.out.println();
                            DisplayMenu(items);
                            System.out.print("Enter your selection: ");
                            choice = input.nextInt();
                        }
                    } else {
                        System.out.println();
                        int i = 1;
                        for (Item a : cart) {
                            System.out.println(i + ". " + a.getName() + " - $" + a.getPrice() + " - " + a.getQuantity());
                            i++;
                        }
                        System.out.print("Please select an item to remove from your cart:");
                        int remove = input.nextInt();
                        for (Item a : cart) {
                            for (i = 0; i < remove; i++) {
                                if (remove - 1 == i) {
                                    a.setQuantity(0);
                                }
                            }
                        }
                        System.out.println("The item has been removed from your cart.");

                        DisplayMenu(items);
                        System.out.print("Enter your selection: ");
                        choice = input.nextInt();

                        while (choice < 1 || choice > 3) {
                            System.out.println("Invalid selection. Please try again.");
                            System.out.println();
                            DisplayMenu(items);
                            System.out.print("Enter your selection: ");
                            choice = input.nextInt();

                            DisplayMenu(items);
                            System.out.print("Enter your selection: ");
                            choice = input.nextInt();

                            while (choice < 1 || choice > 3) {
                                System.out.println("Invalid selection. Please try again.");
                                System.out.println();
                                DisplayMenu(items);
                                System.out.print("Enter your selection: ");
                                choice = input.nextInt();
                            }
                        }
                    }
                }
                if (choice == 3) {
                    System.out.println();
                    System.out.println("Here is your receipt.");
                    System.out.println();
                    sum = 0;
                    for (Item a : cart) {
                        System.out.println(a.getName() + " - " + a.getQuantity() + " - $" + (a.getQuantity() * a.getPrice()));
                        sum += (a.getQuantity() * a.getPrice());
                    }
                    System.out.println();
                    System.out.println("Total: $" + sum);
                    System.out.println();
                    System.out.println("Thank you for shopping wih us! Is there another customer who would like to shop here?");
                    System.out.print("Enter a selection (1. Yes/ 2. No): ");
                    newChoice = input.nextInt();

                    while (newChoice < 1 || newChoice > 2) {
                        System.out.println("Invalid selection. Please try again.");
                        System.out.print("\nEnter a selection (1. Yes/ 2. No): ");
                        newChoice = input.nextInt();
                    }
                }
            }
        }
        System.out.println("Thank you for shopping with us!");
    }
}

