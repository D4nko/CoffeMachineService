package pl.projekt.Enums;

import lombok.*;

import java.util.Arrays;
import java.util.Objects;


@ToString
@Getter
public enum CoffeeType {
    ESPRESSO(1, "Espresso"), CAPPUCCINO(2, "Cappuccino"), LATTE(3, "Latte"), AMERICANO(4, "Americano"), FLATWHITE(5, "FlatWhite"), IRISH(6, "Irish");

    private int id;
    private String name;

    CoffeeType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CoffeeType next(CoffeeType currentType) {
        return Arrays.stream(values())
                .filter(Objects::nonNull)
                .filter(type -> type.ordinal() == (currentType.ordinal() + 1) % values().length)
                .findFirst()
                .orElse(currentType);
    }

    public static CoffeeType previous(CoffeeType currentType) {
        return Arrays.stream(values())
                .filter(Objects::nonNull)
                .filter(type -> type.ordinal() == (currentType.ordinal() - 1 + values().length) % values().length)
                .findFirst()
                .orElse(currentType);
    }
}