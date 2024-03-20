package ru.mts.hw5.pets;

import ru.mts.hw5.Pet;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
      //  play();
    }

    @Override
    public void play() {
        System.out.println("Я Cat, играю с шариком");
    }
}
