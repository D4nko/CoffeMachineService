package pl.projekt.model;

import lombok.Getter;
import pl.projekt.Enums.CoffeeSize;
import pl.projekt.Enums.CoffeeType;
import pl.projekt.exceptions.*;
import pl.projekt.service.CoffeeHistoryManager;

import java.util.Map;
import java.util.Optional;

@Getter

public class CoffeeMachine {
    private CoffeeHistoryManager historyManager = new CoffeeHistoryManager();
    protected static CoffeeType coffeeType;
    private static CoffeeSize coffeSize;
    private static final double MAX_WATER_LEVEL = 2.0;
    protected static double waterLevel;
    private static int milkLevel;
    private static final int maxMilkLevel = 1000;
    private static int milkAmountForLatte = 0;
    private static int milkAmountForCappuccino = 0;
    private static int waterAmountForLatte = 0;

    protected static Map<Float, CoffeeType> coffeeTypes = Map.of(
            1F, CoffeeType.ESPRESSO,
            2F, CoffeeType.CAPPUCCINO,
            3F, CoffeeType.LATTE,
            4F, CoffeeType.AMERICANO,
            5F, CoffeeType.FLATWHITE
    );

    public CoffeeMachine() {
        coffeeType = CoffeeType.ESPRESSO;
    }

    public CoffeeType nextCoffeeType() {
        return coffeeType = coffeeTypes.entrySet().stream()
                .filter(entry -> entry.getValue() == coffeeType)
                .map(Map.Entry::getKey)
                .findFirst()
                .map(currentKey -> coffeeTypes.getOrDefault((currentKey % coffeeTypes.size()) + 1, coffeeType))
                .orElse(coffeeType);


    }

    public CoffeeType previousCoffeeType() {
        return coffeeType = coffeeTypes.entrySet().stream()
                .filter(entry -> entry.getValue() == coffeeType)
                .map(Map.Entry::getKey)
                .findFirst()
                .map(currentKey -> coffeeTypes.getOrDefault((currentKey - 2 + coffeeTypes.size()) % coffeeTypes.size() + 1, coffeeType))
                .orElse(coffeeType);
    }


    // Nowe metody związane z wodą
    public void setWaterLevel(double waterLevel) {
        if (waterLevel >= 0 && waterLevel <= MAX_WATER_LEVEL) {
            this.waterLevel = waterLevel;
        } else {
            System.out.println(" Nieprawidłowa ilość wody w zbiorniku.");
        }
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public void addWater(double waterAmount) {
        if (waterAmount > 0 && waterLevel + waterAmount <= MAX_WATER_LEVEL) {
            waterLevel += waterAmount;
            System.out.println("Dodano wodę do zbiornika.");
        } else {
            throw new NotEnoughWaterException(" Nie można dodać takiej ilości wody.");
        }
    }

    public void dispenseWater(double waterAmount) {
        if (waterAmount > 0 && waterLevel >= waterAmount) {
            waterLevel -= waterAmount;
            System.out.println("Zużyto wodę na przygotowanie kawy.");
        } else {
            throw new NotEnoughWaterException("Błąd: Nie można zużyć takiej ilości wody.");
        }
    }

    public void setMilkLevel(int milkLevel) {
        if (milkLevel >= 0 && milkLevel <= maxMilkLevel) {
            this.milkLevel = milkLevel;
        } else {
            System.out.println("Błąd: Nieprawidłowa ilość mleka w zbiorniku.");
        }
    }

    public int getMilkLevel() {
        return milkLevel;
    }

    public void addMilk(int milkAmount) {
        if (milkAmount > 0 && milkLevel + milkAmount <= maxMilkLevel) {
            milkLevel += milkAmount;
            System.out.println("Dodano mleko do zbiornika.");
        } else {
            System.out.println("Błąd: Nie można dodać takiej ilości mleka do zbiornika.");
        }
    }

    public void dispenseMilk(int milkAmount) {
        if (milkAmount > 0 && milkLevel >= milkAmount) {
            milkLevel -= milkAmount;
            System.out.println("Zużyto mleko na przygotowanie kawy.");
        } else {
            System.out.println("Błąd: Nie wystarczająca ilość mleka w zbiorniku.");
        }
    }

    public void increaseMilk() {
        if (coffeeType == CoffeeType.LATTE) {
            if (milkAmountForLatte + 20 <= maxMilkLevel) {
                milkAmountForLatte += 20;
                System.out.println("Dodano 20ml mleka do kawy.");
            } else {
                throw new ToMuchMilkException(" Nie można dodać więcej mleka do kawy Latte.");
            }
        } else if (coffeeType == CoffeeType.CAPPUCCINO) {
            if (milkAmountForCappuccino + 20 <= maxMilkLevel) {
                milkAmountForCappuccino += 20;
                System.out.println("Dodano 20ml mleka do kawy.");
            } else {
                throw new ToMuchMilkException(" Nie można dodać więcej mleka do kawy Cappuccino.");
            }
        } else {
            throw new WrongUseMilkException(" Mleko można dodawać tylko do kaw Latte i Cappuccino.");
        }
    }

    public void decreaseMilk() {
        if (coffeeType == CoffeeType.LATTE) {
            if (milkAmountForLatte - 20 >= 0) {
                milkAmountForLatte -= 20;
                System.out.println("Odejmuję 20ml mleka od kawy.");
            } else {
                throw new CantTakeAwayMilkException(" Nie można odjąć więcej mleka od kawy Latte.");
            }
        } else if (coffeeType == CoffeeType.CAPPUCCINO) {
            if (milkAmountForCappuccino - 20 >= 0) {
                milkAmountForCappuccino -= 20;
                System.out.println("Odejmuję 20ml mleka od kawy.");
            }
        }
    }

    public void makeCoffee() {
        double WATER_AMOUNT_FOR_OTHERS = 0.2;
        if (coffeeType == CoffeeType.LATTE || coffeeType == CoffeeType.CAPPUCCINO) {
            if (waterLevel < waterAmountForLatte || milkLevel < milkAmountForLatte) {
                System.out.println("Nie można przygotować kawy. Brakuje wody lub mleka.");
                return;
            }
            waterLevel -= waterAmountForLatte;
            milkLevel -= milkAmountForLatte;
        } else {
            if (waterLevel < WATER_AMOUNT_FOR_OTHERS) {
                System.out.println("Nie można przygotować kawy. Brakuje wody.");
                return;
            }
            waterLevel -= WATER_AMOUNT_FOR_OTHERS;
        }

        System.out.println("🖨 Twoja kawa \"" + coffeSize.name().toLowerCase() + " " + coffeeType.getName().toLowerCase() + "\" jest już zrobiona! Wykorzystano: "
                + (coffeeType == CoffeeType.LATTE || coffeeType == CoffeeType.CAPPUCCINO ? waterAmountForLatte : WATER_AMOUNT_FOR_OTHERS) + "l wody oraz "
                + (coffeeType == CoffeeType.LATTE || coffeeType == CoffeeType.CAPPUCCINO ? milkAmountForLatte + "ml mleka." : "0ml mleka."));

    }


    private int calculateMilkNeeded() {
        switch (coffeeType) {
            case LATTE:
                return milkAmountForLatte;
            case CAPPUCCINO:
                return milkAmountForCappuccino;
            default:
                return 0;
        }
    }

    public void showStatus() {
        System.out.println("🖨 Stan ekspresu");
        System.out.println("————————————");
        System.out.println("Rodzaj kawy: " + coffeeType.getName());
        System.out.println("Wielkość kawy: " + coffeSize.name().toLowerCase());

        if (coffeeType == CoffeeType.LATTE || coffeeType == CoffeeType.CAPPUCCINO) {
            System.out.println("Ilość wody w kawie: " + waterAmountForLatte + "l");
            System.out.println("Ilość mleka w kawie: " + milkAmountForLatte + "ml");
        } else {
            System.out.println("Ilość wody w kawie: 0,0l");
            System.out.println("Ilość mleka w kawie: 0ml");
        }

        System.out.println("Ilość wody w zbiorniku: " + waterLevel + "l");
        System.out.println("Ilość mleka w zbiorniku: " + milkLevel + "ml");
    }

}
