package pl.projekt.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum CoffeeSize {
    SMALL(1, "Small"), MEDIUM(2, "Medium"), LARGE(3, "Large");

    private int id;
    private String name;
}
