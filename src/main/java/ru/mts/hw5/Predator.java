package ru.mts.hw5;

import java.time.LocalDate;

public class Predator extends AbstractAnimal {

    public Predator(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
        eat();
    }

    public void eat() {
        System.out.println("Ем любое мясо");
    }
}
