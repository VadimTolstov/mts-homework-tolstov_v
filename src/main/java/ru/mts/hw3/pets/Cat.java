package ru.mts.hw3.pets;

import ru.mts.hw3.Pet;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
    }

    @Override
    public void play() {
        System.out.println("Я Cat, играю с шариком");
    }
}
