package pl.projekt.model;

import pl.projekt.Enums.CoffeeType;

public class QuickBrew extends CoffeeMachine {
    private boolean useDefaultUnits = true;

    public void changeUnits() {
        useDefaultUnits = !useDefaultUnits;
    }




    public CoffeeType makeIrishCoffee() {
        System.out.println("Making Irish Coffee");
        return CoffeeType.IRISH;
    }

    @Override
    public void addWater(double waterAmount) {
        if (!useDefaultUnits) {
            waterAmount = convertLitersToPints((float) waterAmount);
        }
        super.addWater(waterAmount);
    }

    @Override
    public void dispenseWater(double waterAmount) {
        if (!useDefaultUnits) {
            waterAmount = convertLitersToPints((float) waterAmount);
        }
        super.dispenseWater(waterAmount);
    }

    @Override
    public void addMilk(int milkAmount) {
        if (!useDefaultUnits) {
            milkAmount = (int) convertMillilitersToPints(milkAmount);
        }
        super.addMilk(milkAmount);
    }

    @Override
    public void dispenseMilk(int milkAmount) {
        if (!useDefaultUnits) {
            milkAmount = (int) convertMillilitersToPints(milkAmount);
        }
        super.dispenseMilk(milkAmount);
    }

    private float convertLitersToPints(float liters) {
        return (float) Math.ceil(liters / 0.47318);
    }

    private float convertMillilitersToPints(float milliliters) {
        return convertLitersToPints(milliliters / 1000);
    }
}
