package ru.mts.hw3.predators;

import ru.mts.hw3.Predator;

import java.time.LocalDate;

public class Wolf extends Predator {
    public Wolf(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
    }

    @Override
    public void eat() {
        System.out.println("Я Wolf, ем зайцев");
    }
}
