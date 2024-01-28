package pl.projekt.service;

import lombok.Getter;
import pl.projekt.Enums.CoffeeSize;
import pl.projekt.Enums.CoffeeType;
import pl.projekt.model.CoffeeHistory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
public class CoffeeHistoryManager {

    private List<CoffeeHistory> recentCoffeeHistory = new ArrayList<>();
    private List<CoffeeHistory> coffeeHistory = new ArrayList<>();

    public void addToCoffeeHistory(CoffeeType coffeeType, CoffeeSize coffeeSize, float waterAmount, int milkAmount, boolean cupPreheated) {
        CoffeeHistory coffeeHistory = CoffeeHistory.createCoffeeHistory(LocalDateTime.now(), coffeeType, coffeeSize, waterAmount, milkAmount, cupPreheated);

        recentCoffeeHistory.add(coffeeHistory);
        if (recentCoffeeHistory.size() > 30) {
            recentCoffeeHistory.remove(0);
        }
    }

    public void analyse() {


        int totalCoffees = coffeeHistory.size();
        double totalWaterConsumed = coffeeHistory.stream().mapToDouble(CoffeeHistory::getWaterAmount).sum();
        int totalMilkConsumed = coffeeHistory.stream().mapToInt(CoffeeHistory::getMilkAmount).sum();

        System.out.println("Analysis Results:");
        System.out.println("Total Coffees: " + totalCoffees);
        System.out.println("Total Water Consumed: " + totalWaterConsumed + "ml");
        System.out.println("Total Milk Consumed: " + totalMilkConsumed + "ml");

    }
}
