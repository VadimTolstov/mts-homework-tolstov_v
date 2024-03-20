package ru.mts.hw5.pets;

import lombok.experimental.SuperBuilder;
import ru.mts.hw5.Pet;

@SuperBuilder
public class Cat extends Pet {
    @Override
    public void play() {
        System.out.println("Я Cat, играю с шариком");
    }
}
