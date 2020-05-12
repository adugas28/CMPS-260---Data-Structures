// Austin Dugas
// C00231110
// CMPS 260
// Programming Assignment: #9
// Due Date: Friday, May 1, 2020
// Program Description: This program practices using recursion in different situation. The first one
//                      adds the number of integers from 0 to a positive value entered by the user.
//                      The next adds all the odd numbers from 0 to the same positive integer entered
//                      by the user. The next squares a number until it reaches over 1,000. The last
//                      asks the user how many times to repeat a string then repeats it.
// Certificate of Authenticity:
// I certify that the code in this project is, other than code provided by the instructor or that was
// created by Intellij, entirely my own work.

package com.company;

import java.util.Scanner;

public class Main {


    // #1
    // This recursive method returns the sum of all the integers from 0 to the
    // positive integer value passed to the parameter n.
    //
    public static int sumPositive(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return sumPositive(n - 1) + n;
        }
    }


    // #2
    // This recursive method returns the sum of all the odd integers from 1 to the
    // positive integer value passed to the parameter n,
    //
    public static int sumOdd(int n) {
        if (n % 2 == 0)
            n--;
        if  (n == 1) {
            return 1;
        } else {
            return sumOdd(n - 2) + n;
        }
    }


    // #3
    // This recursive method squares a number until the result is greater than or
    // equal to 1,000.  It then returns the result.
    //
    public static double squareSails(double d) {
        if (d == 1) {
            return 1;
        }
        if (d >= 1000) {
            return d;
        } else {
            return squareSails(d * d);
        }

    }


    // #4
    // Write a void recursive method that receives a string and a positive integer,
    // then outputs the string the integer number of times.  For example, if the
    // integer is 3 and the string was "Howdy!", the output would be
    //     Howdy!
    //     Howdy!
    //     Howdy!
    //
    // Tip: "return;" may be used in a void method.
    //
    public static void repeatString(int a, String b) {
        if(a == 0) {
            return;
        } else {
            System.out.println(b);
            repeatString(a - 1, b);
        }
    }



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // input and calls to #1 and #2
        System.out.print("Enter a positive integer value to sum the positive and odd positive integers: ");
        int n = input.nextInt();
        System.out.println("Sum of the positive integers from 0 to " + n + " is " + sumPositive(n));
        System.out.println("Sum of the odd positive integers from 1 to " + n + " is " + sumOdd(n));


        // input and call to #3
        System.out.print("\nEnter a double value to be squared until the result is over 1000: ");
        double d = input.nextInt();
        System.out.println("The result at or past 1,000 by squaring " +  d + " is " + squareSails(d));


        // input and call to #4
        System.out.print("\nEnter the number of times to repeat a message: ");
        int x = input.nextInt();
        System.out.print("Enter a message: ");
        input.nextLine();
        String y = input.nextLine();
        repeatString(x, y);
    }
}
