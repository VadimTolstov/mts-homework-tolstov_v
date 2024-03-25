package ru.mts.hw5.services;

import org.apache.commons.lang3.ObjectUtils;
import ru.mts.hw5.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public Map<String, List<Animal>> createAnimal() {
        Map<String, List<Animal>> mapAnimals = new HashMap<>();
        List<Animal> startingList = new ArrayList<>();
        List<List<Animal>> listAnimals = new ArrayList<>();
        Animal animal;
        animal = randomAnimal();
        startingList.add(animal);
        listAnimals.add(startingList);
        boolean isListWasNotFound = true;
        int i = 1;
        do {
            animal = randomAnimal();
            if (ObjectUtils.isNotEmpty(animal)) {
                for (List<Animal> listAnimal : listAnimals) {
                    if (animal.getClass().equals(listAnimal.get(0).getClass())) {
                        listAnimal.add(animal);
                        isListWasNotFound = false;
                    }
                }

                while (isListWasNotFound) {
                    List<Animal> list = new ArrayList<>();
                    list.add(animal);
                    listAnimals.add(list);
                    isListWasNotFound = false;
                }
                isListWasNotFound = true;
                i++;
            }
        } while (i < 10);
        addingAnimalsInMap(mapAnimals, listAnimals);

        return mapAnimals;

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
