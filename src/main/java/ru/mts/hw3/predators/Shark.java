package ru.mts.hw3.predators;

import ru.mts.hw3.Predator;

import java.time.LocalDate;

public class Shark extends Predator {
    public Shark(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    @Override
    public void eat() {
        System.out.println("Я Shark, ем рыбу");
    }
}
