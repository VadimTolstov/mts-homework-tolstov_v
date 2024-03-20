package ru.mts.hw5.pets;

import lombok.experimental.SuperBuilder;
import ru.mts.hw5.Pet;

@SuperBuilder
public class Dog extends Pet {
    @Override
    public void play() {
        System.out.println("Я Dog, мяч моя игрушка");
    }
}
