package ru.mts;

import ru.mts.hw3.services.CreateAnimalServiceImpl;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        createAnimalService.createAnimal();
    }
}