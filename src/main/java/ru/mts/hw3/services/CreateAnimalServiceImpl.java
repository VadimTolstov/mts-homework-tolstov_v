package ru.mts.hw3.services;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public void createAnimal() {
        int i = 0;
        do {
            randomAnimal();
            i++;
        } while (i < 10);
    }

    public void addAnimal(String breed, String name, Double cost, String character, int count) {
        for (int i = 0; i < 3; i++){

        }

    }
}
