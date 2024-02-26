package ru.mts.hw3.predators;

import ru.mts.hw3.Predator;

public class Shark extends Predator {
    public Shark(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
        eat();
    }

    @Override
    public void eat() {
        System.out.println("Ем рыбу");
    }
}
