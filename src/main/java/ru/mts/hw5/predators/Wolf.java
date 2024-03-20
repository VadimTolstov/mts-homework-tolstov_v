package ru.mts.hw5.predators;

import lombok.experimental.SuperBuilder;
import ru.mts.hw5.Predator;

@SuperBuilder
public class Wolf extends Predator {
    @Override
    public void eat() {
        System.out.println("Я Wolf, ем зайцев");
    }
}
