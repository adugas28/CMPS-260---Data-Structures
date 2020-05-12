package com.company;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item() { }

    public Item(String a, double b, int c) {
        if (a == null) {
            a = "Bread";
            name = a;
        }
        if (b < 0) {
            b = 2.99;
            price = b;
        }
        if (c < 0) {
            c = 25;
            quantity = c;
        }
        name = a;
        price = b;
        quantity = c;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int a) {
        quantity = a;
    }
}
