package ru.mts.hw3;

public class Predator extends AbstractAnimal {

    public Predator(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
    }

    public void eat() {
        System.out.println("Ем любое мясо");
    }
}
