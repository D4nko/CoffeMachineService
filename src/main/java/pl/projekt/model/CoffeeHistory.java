package pl.projekt.model;

import lombok.Getter;
import lombok.Setter;
import pl.projekt.Enums.CoffeeSize;
import pl.projekt.Enums.CoffeeType;

import java.time.LocalDateTime;

@Getter
@Setter

public class CoffeeHistory {
    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;
    private LocalDateTime preparationDate;
    private double waterAmount;
    private int milkAmount;
    private boolean isCupPreheated;

    public CoffeeHistory(CoffeeType coffeeType, CoffeeSize coffeeSize, LocalDateTime preparationDate, double waterAmount, int milkAmount, boolean isCupPreheated) {
        this.coffeeType = coffeeType;
        this.coffeeSize = coffeeSize;
        this.preparationDate = preparationDate;
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
        this.isCupPreheated = isCupPreheated;
    }

    public boolean isCupPreheated() {
        return isCupPreheated;
    }
}
