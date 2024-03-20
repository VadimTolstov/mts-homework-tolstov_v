package ru.mts.hw5.services;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import ru.mts.hw5.AbstractAnimal;
import ru.mts.hw5.Animal;
import ru.mts.hw5.pets.Cat;
import ru.mts.hw5.pets.Dog;
import ru.mts.hw5.predators.Shark;
import ru.mts.hw5.predators.Wolf;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public interface CreateAnimalService {

    List<String> charactersList = List.of("Злой", "Добрый", "Нейтральный");
    List<String> nameList = List.of("Валера", "Зоя", "Анатолий", "Федя", "Анна");
    List<String> breedList = List.of("Итальянская", "Русская", "Американская", "Немецкая");

    default AbstractAnimal randomAnimal() throws NullPointerException {
        switch (new Random().nextInt(1, 5)) {
            case 1:
                Shark shark = Shark.builder()
                        .breed(randomSpecifications(breedList))
                        .name(randomSpecifications(nameList))
                        .cost(randomPrice())
                        .character(randomSpecifications(charactersList))
                        .birthDate(randomDate())
                        .build();
                System.out.println(shark);
                return shark;
            case 2:
                Wolf wolf = Wolf.builder()
                        .breed(randomSpecifications(breedList))
                        .name(randomSpecifications(nameList))
                        .cost(randomPrice())
                        .character(randomSpecifications(charactersList))
                        .birthDate(randomDate())
                        .build();
                System.out.println(wolf);
                return wolf;
            case 3:
                Dog dog = Dog.builder()
                        .breed(randomSpecifications(breedList))
                        .name(randomSpecifications(nameList))
                        .cost(randomPrice())
                        .character(randomSpecifications(charactersList))
                        .birthDate(randomDate())
                        .build();
                System.out.println(dog);
                return dog;
            case 4:
                Cat cat = Cat.builder()
                        .breed(randomSpecifications(breedList))
                        .name(randomSpecifications(nameList))
                        .cost(randomPrice())
                        .character(randomSpecifications(charactersList))
                        .birthDate(randomDate())
                        .build();
                System.out.println(cat);
                return cat;
        }
        return null;
    }

    default Map<String, List<Animal>> createAnimal() {
        Map<String, List<Animal>> mapAnimals = new HashMap<>();
        List<Animal> startingList = new ArrayList<>();
        List<List<Animal>> listAnimals = new ArrayList<>();
        Animal animal;
        animal = randomAnimal();
        startingList.add(animal);
        listAnimals.add(startingList);
        boolean isListWasNotFound = true;
        int i = 1;
        while (i < 10) {
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
        }
        addingAnimalsInMap(mapAnimals, listAnimals);

        return mapAnimals;
    }

    default void addingAnimalsInMap(Map<String, List<Animal>> map, List<List<Animal>> animals) {
        if (CollectionUtils.isNotEmpty(animals)) {
            for (List<Animal> animal : animals) {
                map.put(animal.get(0).getClass().getSimpleName(), animal);
            }
        }
    }

    private String randomSpecifications(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    private Double randomPrice() {
        return new Random().nextDouble(1, 100000);
    }

    private LocalDate randomDate() {
        int hundredYears = 100 * 365;
        return LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(-hundredYears, hundredYears));
    }
}

