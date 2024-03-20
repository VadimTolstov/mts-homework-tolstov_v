package ru.mts.hw5.predators;

import ru.mts.hw5.Predator;

import java.time.LocalDate;

public class Wolf extends Predator {
    public Wolf(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
  //      eat();
    }

    @Override
    public void eat() {
        System.out.println("Я Wolf, ем зайцев");
    }
}
