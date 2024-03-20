package ru.mts.hw5;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Pet extends AbstractAnimal {
    public void play() {
        System.out.println("Люблю играть ");
    }
}
