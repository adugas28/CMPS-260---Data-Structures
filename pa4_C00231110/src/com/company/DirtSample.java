package com.company;

public class DirtSample {

    //Initialize the variables
    private double sand = 0;
    private double clay = 0;
    private double other = 0;

    //Create a default constructor
    public DirtSample() {
    }

    //Create the parameterized constructor
    public DirtSample(double a, double b, double c) {
        setSand(a);
        setClay(b);
        setOther(c);
    }

    //Create getters for each dirt type
    public double getSand() {
        return sand;
    }

    public double getClay() {
        return clay;
    }

    public double getOther() {
        return other;
    }

    //Create setters for each dirt type
    public void setSand(double initA) {
        if (initA > 0) {
            sand = initA;
        }
    }

    public void setClay(double initB) {
        if (initB > 0) {
            clay = initB;
        }
    }
    public void setOther(double initC) {
        if (initC > 0) {
            other = initC;
        }
    }

    //Create methods to calculate the percent of each dirt type
    //in a sample
    public double percentSand() {
        return (sand / (sand + clay + other)) * 100;
    }

    public double percentClay() {
        return (clay / (sand + clay + other)) * 100;
    }

    public double percentOther() {
        return (other / (sand + clay + other)) * 100;
    }

    //Create method that calculates the total weight
    public double totalWeight() {
        return (sand + clay + other);
    }
}