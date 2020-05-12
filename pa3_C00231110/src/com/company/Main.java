// Austin Dugas
// C00231110
// CMPS 260
// Programming Assignment: #3
// Due Date: Thursday, February 13, 2020
// Program Description: This program contains four methods. One method sorts three integers
//                      from greatest to least. One method poses a question to the user to
//                      answer and checks if the input is correct or not. One method
//                      approximates the square root of a user given value using the
//                      Babylonian method. The final method creates a right triangle based
//                      on the integer given by the user.
// Certificate of Authenticity:
// I certify that the code in the methods in the main class of this project is entirely my own
// work.

package com.company;

import java.util.Scanner;

public class Main {

    public static void Sorting(int a, int b, int c) {
        if (a >= b && a >= c) {
            if (b >= c) {
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println(a + " " + c + " " + b);
            }
        } else if (b >= a && b >= c) {
            if (a >= c) {
                System.out.println(b + " " + a + " " + c);
            } else {
                System.out.println(b + " " + c + " " + a);
            }
        } else {
            if (a >= b) {
                System.out.println(c + " " + a + " " + b);
            } else {
                System.out.println(c + " " + b + " " + a);
            }
        }
    }

    public static boolean Question(String question, String answer, Scanner input) {
        System.out.println(question);
        String userInput = input.nextLine();
        return answer.compareTo(userInput) == 0;
    }

    public static double SqrtGuess(double n, double lastGuess) {
        if (n < 0) {
            n = -n;
        } else if (n == 0) {
            n = 1;
        }
        double nextGuess = ((lastGuess + n) / lastGuess) / 2;
        while(nextGuess - lastGuess > 0.0001) {
            lastGuess = nextGuess;
            nextGuess = ((lastGuess + n) / lastGuess) / 2;
        }
        lastGuess = nextGuess;
        return ((lastGuess + n) / lastGuess) / 2;
    }

    public static void Triangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);

        // Calls the method to sort three integers
        System.out.print("Enter three integers separated by spaces: ");
        int one = input.nextInt();
        int two = input.nextInt();
        int three = input.nextInt();
        Sorting(one,two,three);
        System.out.println();

        // Calls the method to answer the question
        String question = "Hard red fruit about the size of a softball.";
        String answer = "apple";
        boolean response = Question(question, answer, input);
        while (!response) {
            System.out.println("Incorrect");
            response = Question(question, answer, input);
        }
        System.out.println("Correct");
        System.out.println();

        // Calls the method that approximates the square root of the integer inputted
        System.out.print("Enter a number and guess its square root: ");
        double n = input.nextDouble();
        double lastGuess = input.nextDouble();
        double finalGuess = SqrtGuess(n, lastGuess);
        System.out.println("Approximate square root of " + n + " is " + finalGuess);
        System.out.println();

        // Calls the method to print right triangle
        System.out.print("Enter a positive integer: ");
        int triangle = input.nextInt();
        Triangle(triangle);

    }
}
