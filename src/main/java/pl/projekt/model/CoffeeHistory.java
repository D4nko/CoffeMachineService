package pl.projekt.model;

import lombok.*;
import pl.projekt.Enums.CoffeeSize;
import pl.projekt.Enums.CoffeeType;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CoffeeHistory {
    private LocalDateTime preparationDate;
    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;
    private float waterAmount;
    private int milkAmount;
    private boolean cupPreheated;

    // Static method for creating a new instance
    public static CoffeeHistory createCoffeeHistory(LocalDateTime preparationDate, CoffeeType coffeeType,
                                                    CoffeeSize coffeeSize, float waterAmount, int milkAmount,
                                                    boolean cupPreheated) {
        return new CoffeeHistory(preparationDate, coffeeType, coffeeSize, waterAmount, milkAmount, cupPreheated);
    }
}
