package com.company;

public class Planter extends Dirt {

    private String plant;
    private int planterSize = 0;

    public Planter() { }

    public Planter(String plantName, int planterSizeNum) {
        super();
        plant = plantName;
        if (planterSizeNum > 0) {
            planterSize = planterSizeNum;
        }
    }

    public String getPlant() {
        return plant;
    }

    public int getPlanterSize() {
        return planterSize;
    }

    public int getPartsSand() {
        return super.getPartsSand();
    }

    public int getPartsClay() {
        return super.getPartsClay();
    }

    public int getPartsOther() {
        return super.getPartsOther();
    }

    public boolean checkDirt() {
        if (super.getPartsClay() > 0 && super.getPartsSand() > 0 && super.getPartsOther() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Planter createFlower() {
        return new Planter("Flower", 5);
    }

    public static Planter createMint() {
        return new Planter("Mint", 25);
    }

    public static Planter createFicus() {
        return new Planter("Ficus", 100);
    }

}
