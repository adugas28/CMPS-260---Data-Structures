package com.company;

public class Garden {

    private Plant[] plantTypes = null;
    private int numPlants = 0;
    private int numDaysSinceWatered = 0;

    public Garden() {
        plantTypes = new Plant[3];
    }

    public Garden(int maxPlants) {
        if (maxPlants > 3) {
            plantTypes = new Plant[maxPlants];
        } else {
            plantTypes = new Plant[3];
        }
    }

    public int getNumPlants() {
        return numPlants;
    }

    public int getNumDaysWatered() {
        return numDaysSinceWatered;
    }

    public void setNumDaysWatered(int newDay) {
        if (newDay > 0) {
            numDaysSinceWatered = newDay;
        }
    }

    public void addPlantCreated(Plant a) {
        for (int i = 0; i < plantTypes.length; i++) {
            if (plantTypes[i] == null) {
                plantTypes[i] = a;
                numPlants += 1;
                break;
            }
        }
    }

    public void addNewPlant(String s, double h) {
        Plant newPlant = new Plant(s, h);
        for (int i = 0; i < plantTypes.length; i++) {
            if (plantTypes[i] == null) {
                plantTypes[i] = newPlant;
                numPlants += 1;
                break;
            }
        }
    }

    public String getInfo(int index) {
        String info = null;
        for (int i = 0; i < plantTypes.length; i++) {
            if (i == index - 1) {
                info = plantTypes[i].toString();
            }
        }
        return info;
    }

    public void checkWatering() {
        for (int i = 0; i < plantTypes.length; i++) {
            if (plantTypes[i].getNeedsWater() == true) {
                for (int j = 0; j < plantTypes.length; j++) {
                    plantTypes[i].waterPlant();
                }
                numDaysSinceWatered = 0;
            }
        }
    }

    public void allInfo() {
        for (int i = 0; i < plantTypes.length; i++) {
            System.out.println(plantTypes[i].toString());
        }
    }
}