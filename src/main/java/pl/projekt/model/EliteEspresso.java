package pl.projekt.model;

import pl.projekt.Enums.CoffeeType;
import pl.projekt.interfaces.IPreheatCup;

public class EliteEspresso extends CoffeeMachine implements IPreheatCup {

    private int beansAmount = 100;
    private static final float MAX_WATER_LEVEL_ELITE = 2.5f;
    private static final float WATER_AMOUNT_FOR_LATTE_ELITE = 0.04f;

    public EliteEspresso() {
        coffeeTypes.put(1F, CoffeeType.ESPRESSO);
        coffeeTypes.put(2F, CoffeeType.CAPPUCCINO);
        coffeeTypes.put(3F, CoffeeType.LATTE);
        coffeeTypes.put(4F, CoffeeType.AMERICANO);
        coffeeTypes.put(5F, CoffeeType.FLATWHITE);
        waterLevel = MAX_WATER_LEVEL_ELITE;
    }

    public void addCoffeeBeans(int amount) {
        beansAmount += amount;
        System.out.println("Dolano " + amount + " ziaren kawy. Aktualna ilość ziaren kawy: " + beansAmount);
    }

    @Override
    public void preheatCup() {
        boolean cupPreheated = true;
        System.out.println("Filiżanka została podgrzana.");
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        if (coffeeType == CoffeeType.LATTE) {
            waterLevel -= WATER_AMOUNT_FOR_LATTE_ELITE;
        }
    }

    @Override
    public void showStatus() {
        super.showStatus();
    }
}
