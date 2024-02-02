package pl.projekt.model;

import lombok.Getter;
import pl.projekt.Enums.CoffeeSize;
import pl.projekt.Enums.CoffeeType;
import pl.projekt.service.CoffeeHistoryAnalyzer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EliteEspresso extends CoffeeMachine {
    @Getter
    private double coffeeBeansAmount; // Ilość dosypanych ziaren kawy
    private List<CoffeeHistory> coffeeHistory;

    public EliteEspresso() {
        super();
        this.coffeeBeansAmount = 0.0;
        this.coffeeHistory = new ArrayList<>();
    }

    @Override
    public void analyze() {
        CoffeeHistoryAnalyzer.analyze(coffeeHistory);
    }

    public void setCoffeeBeansAmount(double amount) {
        this.coffeeBeansAmount = amount;
    }

    public void preheatCup() {
        System.out.println("Podgrzewanie filiżanki...");
        // Logika podgrzewania filiżanki
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("Ilość ziaren kawy: " + coffeeBeansAmount + "g");
    }

    @Override
    public void makeCoffee(CoffeeType coffeeType, CoffeeSize coffeeSize, double waterAmount, int milkAmount) {
        preheatCup();
        super.makeCoffee(coffeeType, coffeeSize, waterAmount, milkAmount);
        saveCoffeeHistory(coffeeType, coffeeSize, waterAmount, milkAmount);
    }

    public List<CoffeeHistory> getRecentCoffeeHistory() {
        return coffeeHistory;
    }

    private void saveCoffeeHistory(CoffeeType coffeeType, CoffeeSize coffeeSize, double waterAmount, int milkAmount) {
        CoffeeHistory entry = new CoffeeHistory(coffeeType, coffeeSize, LocalDateTime.now(), waterAmount, milkAmount,true);
        coffeeHistory.add(entry);

        // Ogranicz historię do ostatnich 30 wpisów
        if (coffeeHistory.size() > 30) {
            coffeeHistory.remove(0);
        }
    }

}