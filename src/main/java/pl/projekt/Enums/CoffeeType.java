package pl.projekt.Enums;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@ToString
@Getter
public enum CoffeeType {

    ESPRESSO(1, "Espresso"),
    CAPPUCCINO(2, "Cappuccino"),
    LATTE(3, "Latte"),
    AMERICANO(4, "Americano"),
    FLATWHITE(5, "FlatWhite"),
    ISRISH(6, "Irish");


    private int id;
    private String name;



}