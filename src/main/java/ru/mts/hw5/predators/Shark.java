package ru.mts.hw5.predators;

import ru.mts.hw5.Predator;

import java.time.LocalDate;

public class Shark extends Predator {
    public Shark(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
    }

    @Override
    public void eat() {
        System.out.println("Я Shark, ем рыбу");
    }
}
