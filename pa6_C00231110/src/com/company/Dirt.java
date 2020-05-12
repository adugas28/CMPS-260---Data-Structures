package com.company;

public class Dirt {
    private int partsSand;
    private int partsClay;
    private int partsOther;
    private int totalParts;

    public Dirt() {
        partsSand = partsClay = partsOther = 0;
    }

    public Dirt(int partsSand, int partsClay, int partsOther) {
        
        if (partsSand >= 0 && partsClay >= 0 && partsOther >= 0) {
            this.partsSand  = partsSand;
            this.partsClay  = partsClay;
            this.partsOther = partsOther;
            totalParts = partsSand + partsClay + partsOther;
        }
    }

    public int getPartsSand() {
        return partsSand;
    }

    public int getPartsClay() {
        return partsClay;
    }

    public int getPartsOther() {
        return partsOther;
    }

    public double getPercentSand() {
        if (totalParts > 0)
            return partsSand / (double)totalParts;
        return 0;

    }

    public double getPercentClay() {
        if (totalParts > 0)
            return partsClay /  (double)totalParts;
        return 0;
    }

    public double getPercentOther() {
        if (totalParts > 0)
            return partsOther /  (double)totalParts;
        return 0;
    }

}
