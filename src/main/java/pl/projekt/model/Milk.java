package pl.projekt.model;

public class Milk {
    private int milkLevel;

    public Milk() {
        this.milkLevel = 0;
    }

    public int getMilkLevel() {
        return milkLevel;
    }

    public void setMilkLevel(int milkLevel) {
        if (milkLevel >= 0 && milkLevel <= 1000) {
            this.milkLevel = milkLevel;
        } else {
            System.out.println("Error: Milk level out of range (0-1000 ml).");
        }
    }

    public void addMilk(int milkAmount) {
        if (milkLevel + milkAmount <= 1000) {
            milkLevel += milkAmount;
        } else {
            System.out.println("Error: Milk level exceeds the maximum capacity.");
        }
    }

    public void dispenseMilk(int milkAmount) {
        if (milkLevel - milkAmount >= 0) {
            milkLevel -= milkAmount;
        } else {
            System.out.println("Error: Not enough milk in the tank.");
        }
    }
}
