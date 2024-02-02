package pl.projekt.service;

import pl.projekt.Enums.CoffeeType;
import pl.projekt.model.CoffeeHistory;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeHistoryAnalyzer {
    public static void analyze(List<CoffeeHistory> coffeeHistory) {
        if (coffeeHistory.isEmpty()) {
            System.out.println("Brak danych do analizy historii przygotowywania kaw.");
            return;
        }

        CoffeeType favoriteCoffee = findFavoriteCoffee(coffeeHistory);

        double averageCoffeesPerDay = calculateAverageCoffeesPerDay(coffeeHistory);

        // Wyświetl wyniki analizy
        System.out.println("Analiza historii przygotowywania kaw:");
        System.out.println("Ulubiona kawa: " + favoriteCoffee.getName());
        System.out.println("Średnia liczba kaw dziennie: " + averageCoffeesPerDay);
    }

    private static CoffeeType findFavoriteCoffee(List<CoffeeHistory> coffeeHistory) {
        Map<CoffeeType, Integer> coffeeCountMap = new HashMap<>();

        // Zlicz wystąpienia każdego rodzaju kawy w historii
        for (CoffeeHistory entry : coffeeHistory) {
            CoffeeType coffeeType = entry.getCoffeeType();
            coffeeCountMap.put(coffeeType, coffeeCountMap.getOrDefault(coffeeType, 0) + 1);
        }

        // Znajdź kawę z największą ilością wystąpień
        CoffeeType favoriteCoffee = CoffeeType.ESPRESSO; // Domyślna wartość
        int maxCount = 0;

        for (Map.Entry<CoffeeType, Integer> entry : coffeeCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                favoriteCoffee = entry.getKey();
            }
        }

        return favoriteCoffee;
    }

    private static double calculateAverageCoffeesPerDay(List<CoffeeHistory> coffeeHistory) {
        Map<LocalDate, Integer> dailyCoffeeCount = new HashMap<>();

        // Zlicz kawy na każdy dzień
        for (CoffeeHistory entry : coffeeHistory) {
            LocalDate date = entry.getPreparationDate().toLocalDate();
            dailyCoffeeCount.put(date, dailyCoffeeCount.getOrDefault(date, 0) + 1);
        }

        // Oblicz średnią ilość kaw dziennie
        int totalDays = dailyCoffeeCount.size();
        if (totalDays == 0) {
            return 0.0;
        }

        int totalCoffees = coffeeHistory.size();
        return (double) totalCoffees / totalDays;
    }
}
