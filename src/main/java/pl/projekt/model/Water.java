package pl.projekt.model;

public class Water {
    private double waterLevel;

    public Water() {
        this.waterLevel = 0;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(double waterLevel) {
        if (waterLevel >= 0 && waterLevel <= 2) {
            this.waterLevel = waterLevel;
        } else {
            System.out.println("Error: Water level out of range (0-2 liters).");
        }
    }

    public void addWater(double waterAmount) {
        if (waterLevel + waterAmount <= 2) {
            waterLevel += waterAmount;
        } else {
            System.out.println("Error: Water level exceeds the maximum capacity.");
        }
    }

    public void dispenseWater(double waterAmount) {
        if (waterLevel - waterAmount >= 0) {
            waterLevel -= waterAmount;
        } else {
            System.out.println("Error: Not enough water in the tank.");
        }
    }
}
