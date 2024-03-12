package ru.mts.hw5.pets;

import ru.mts.hw5.Pet;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    @Override
    public void play() {
        System.out.println("Я Dog, мяч моя игрушка");
    }
}
