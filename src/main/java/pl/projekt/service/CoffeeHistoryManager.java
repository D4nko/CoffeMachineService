package pl.projekt.service;

import pl.projekt.Enums.CoffeeSize;
import pl.projekt.Enums.CoffeeType;
import pl.projekt.model.CoffeeHistory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CoffeeHistoryManager {
    private List<CoffeeHistory> coffeeHistoryList;

    public CoffeeHistoryManager() {
        this.coffeeHistoryList = new ArrayList<>();
    }

    public void addCoffeeHistory(LocalDateTime preparationDate, CoffeeType coffeeType, CoffeeSize coffeeSize, double waterAmount, int milkAmount, boolean isCupPreheated) {
        CoffeeHistory coffeeHistory = new CoffeeHistory(coffeeType, coffeeSize, preparationDate, waterAmount, milkAmount, isCupPreheated);
        coffeeHistoryList.add(coffeeHistory);
        limitHistorySize();
    }

    private void limitHistorySize() {
        if (coffeeHistoryList.size() > 30) {
            coffeeHistoryList.remove(0);
        }
    }

    public List<CoffeeHistory> getRecentCoffeeHistory() {
        return new ArrayList<>(coffeeHistoryList);
    }
}
