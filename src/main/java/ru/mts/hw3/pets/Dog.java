package ru.mts.hw3.pets;

import ru.mts.hw3.Pet;

public class Dog extends Pet {
    public Dog(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
        play();
    }

    @Override
    public void play() {
        System.out.println("Я Dog, мяч моя игрушка");
    }
}
