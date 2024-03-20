package ru.mts.hw5;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Predator extends AbstractAnimal {
    public void eat() {
        System.out.println("Ем любое мясо");
    }
}
