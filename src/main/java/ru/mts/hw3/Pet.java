package ru.mts.hw3;

import ru.mts.hw3.AbstractAnimal;

public class Pet extends AbstractAnimal {
    public Pet(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
    }

    public void play(){
        System.out.println("Люблю играть ");
    }
}