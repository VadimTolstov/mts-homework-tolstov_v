package ru.mts.hw3.pets;

import ru.mts.hw3.Pet;

public class Cat extends Pet {
    public Cat(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
        play();
    }

    @Override
    public void play() {
        System.out.println("Играю с шариком");
    }


}
