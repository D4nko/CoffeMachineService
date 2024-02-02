package pl.projekt.application;

import pl.projekt.Enums.CoffeeSize;
import pl.projekt.Enums.CoffeeType;
import pl.projekt.model.CoffeeHistory;
import pl.projekt.model.CoffeeMachine;
import pl.projekt.model.EliteEspresso;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EliteEspresso eliteEspresso = new EliteEspresso();

        // Dodanie ziaren kawy
        eliteEspresso.setCoffeeBeansAmount(200);



        // Przygotowanie kawy
        eliteEspresso.makeCoffee(CoffeeType.ESPRESSO, CoffeeSize.SMALL, 0.1, 0);
        eliteEspresso.makeCoffee(CoffeeType.LATTE, CoffeeSize.MEDIUM, 0.2, 100);
        eliteEspresso.makeCoffee(CoffeeType.CAPPUCCINO, CoffeeSize.LARGE, 0.3, 200);

        eliteEspresso.analyze();




        // Wyświetlenie historii
        List<CoffeeHistory> recentCoffeeHistory = eliteEspresso.getRecentCoffeeHistory();
        for (CoffeeHistory entry : recentCoffeeHistory) {
            System.out.println("Data: " + entry.getPreparationDate());
            System.out.println("Rodzaj kawy: " + entry.getCoffeeType());
            System.out.println("Wielkość kawy: " + entry.getCoffeeSize());
            System.out.println("Ilość wody: " + entry.getWaterAmount() + "l");
            System.out.println("Ilość mleka: " + entry.getMilkAmount() + "ml");
            System.out.println("Podgrzana filiżanka: " + (entry.isCupPreheated() ? "Tak" : "Nie"));
            System.out.println("---------------------------");
        }
    }
}
//        CoffeeMachine coffeeMachine = new CoffeeMachine();
//
//        coffeeMachine.addMilk(coffeeMachine.getMilkAmount());
//        coffeeMachine.addWater(coffeeMachine.getWaterLevel());
//
//
//        // Ustawienie rodzaju kawy
//        coffeeMachine.setCoffeeType(CoffeeType.ESPRESSO);
//        System.out.println("Coffee Type: " + coffeeMachine.getCoffeeType());
//
//        // Zmiana rodzaju kawy
//        coffeeMachine.nextCoffeeType();
//        System.out.println("Next Coffee Type: " + coffeeMachine.getCoffeeType());
//
//        // Ustawienie rozmiaru kawy
//        coffeeMachine.setCoffeeSize(CoffeeSize.MEDIUM);
//        System.out.println("Coffee Size: " + coffeeMachine.getCoffeeSize());
//
//        // Ustawienie poziomu wody
//        coffeeMachine.setWaterLevel(1.5);
//        System.out.println("Water Level: " + coffeeMachine.getWaterLevel());
//
//        // Dodanie wody
//        coffeeMachine.addWater(0.5);
//        System.out.println("Water Level after adding: " + coffeeMachine.getWaterLevel());
//
//        // Zużycie wody
//        coffeeMachine.dispenseWater(1.0);
//        System.out.println("Water Level after dispensing: " + coffeeMachine.getWaterLevel());
//
//        // Ustawienie poziomu mleka
//        coffeeMachine.setMilkLevel(300);
//        System.out.println("Milk Level: " + coffeeMachine.getMilkLevel());
//
//        // Dodanie mleka
//        coffeeMachine.addMilk(200);
//        System.out.println("Milk Level after adding: " + coffeeMachine.getMilkLevel());
//
//        // Zużycie mleka
//        coffeeMachine.dispenseMilk(100);
//        System.out.println("Milk Level after dispensing: " + coffeeMachine.getMilkLevel());
//
//        // Zwiększenie ilości mleka
//        coffeeMachine.increaseMilk();
//        System.out.println("Milk Level after increasing: " + coffeeMachine.getMilkLevel());
//
//        // Zmniejszenie ilości mleka
//        coffeeMachine.decreaseMilk();
//        System.out.println("Milk Level after decreasing: " + coffeeMachine.getMilkLevel());
//
//        // Pobranie ilości mleka przypisanej do rodzaju kawy
//        System.out.println("Milk Amount for the current Coffee Type: " + coffeeMachine.getMilkAmount());
//
//
//        coffeeMachine.makeCoffee(CoffeeType.ESPRESSO, CoffeeSize.MEDIUM, 1.5, 200);
//        coffeeMachine.showStatus();
//
//        coffeeMachine.makeCoffee(CoffeeType.LATTE, CoffeeSize.MEDIUM, 1.5, 200);
//        coffeeMachine.showStatus();
//        coffeeMachine.makeCoffee(CoffeeType.CAPPUCCINO, CoffeeSize.MEDIUM, 1.5, 200);
//
//        coffeeMachine.addMilk(2000);
//        coffeeMachine.addWater(5000);
//    }
//}
