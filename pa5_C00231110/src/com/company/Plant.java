package com.company;

public class Plant {
    private String name;
    private double height;
    private boolean needsWater;

    public Plant(String s, double h) {
        name = s;
        setHeight(h);
        needsWater = (Math.random() > 0.5);
    }

    public Plant() {
        this("Plant", 1);
    }

    public double getHeight()   { return height; }
    public String getName()     { return name; }

    public boolean getNeedsWater() { return needsWater; }
    public void waterPlant()       { needsWater = false; }

    public void setHeight(double height) {
        if(height > 0)
            this.height = height;
    }

    public static Plant createFlower()  { return new Plant("Flower", 1); }
    public static Plant createShrub()   { return new Plant("Shrub", 10); }
    public static Plant createTree()    { return new Plant("Tree", 100); }

    public String toString() {
        return String.format("(%s, %.1f inches, %s)", name, height, (getNeedsWater() ? "needs to be watered" : "does not need to be watered" ));
    }

}
