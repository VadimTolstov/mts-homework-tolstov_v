package ru.mts;

import ru.mts.hw3.services.CreateAnimalServiceImpl;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        createAnimalService.createAnimal();
        createAnimalService.addAnimal(3);
        createAnimalService.addAnimal();

    }
}