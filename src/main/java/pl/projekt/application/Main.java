package pl.projekt.application;

import pl.projekt.model.CoffeeMachine;

public class Main {
    public static void main(String[] args) {


        CoffeeMachine coffeeMachine = new CoffeeMachine();


        for (int i = 0; i < 7; i++) {
            System.out.println(coffeeMachine.nextCoffeeType());
        }
        System.out.println(coffeeMachine.previousCoffeeType());
        System.out.println(coffeeMachine.previousCoffeeType());
    }
}