package ru.mts.hw5.services;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public void createAnimal() {
        int i = 0;
        do {
            randomAnimal();
            i++;
        } while (i < 10);
    }

    public void addAnimal(int count) {
        for (int i = 0; i < count; i++) {
            randomAnimal();
        }
    }

    public void addAnimal() {
        for (int i = 0; i < 3; i++) {
            randomAnimal();
        }
    }
}
