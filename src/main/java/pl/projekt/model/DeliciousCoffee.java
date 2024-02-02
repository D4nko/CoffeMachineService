package pl.projekt.model;

import pl.projekt.Enums.CoffeeSize;
import pl.projekt.Enums.CoffeeType;

public class DeliciousCoffee extends CoffeeMachine {
    private String uniqueFeature;

    public DeliciousCoffee() {
        super();
        this.uniqueFeature = "Delicious Coffee Brand Feature";
    }

    public String getUniqueFeature() {
        return uniqueFeature;
    }

    public void specialDeliciousBrew() {
        System.out.println("Brewing a special delicious coffee with a unique process.");
    }
}
