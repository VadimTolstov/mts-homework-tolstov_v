package ru.mts.hw5.services;

import ru.mts.hw5.AbstractAnimal;
import ru.mts.hw5.pets.Cat;
import ru.mts.hw5.pets.Dog;
import ru.mts.hw5.predators.Shark;
import ru.mts.hw5.predators.Wolf;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public interface CreateAnimalService {

    List<String> charactersList = List.of("Злой", "Добрый", "Нейтральный");
    List<String> nameList = List.of("Валера", "Зоя", "Анатолий", "Федя", "Анна");
    List<String> breedList = List.of("Итальянская", "Русская", "Американская", "Немецкая");

    default AbstractAnimal randomAnimal() throws NullPointerException {
        switch (new Random().nextInt(1, 5)) {
            case 1:
                Shark shark = new Shark(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList), randomDate());
                System.out.println(shark);
                return shark;
            case 2:
                Wolf wolf = new Wolf(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList), randomDate());
                System.out.println(wolf);
                return wolf;
            case 3:
                Dog dog = new Dog(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList), randomDate());
                System.out.println(dog);
                return dog;
            case 4:
                Cat cat = new Cat(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList), randomDate());
                System.out.println(cat);
                return cat;
        }
        return null;
    }

    default void createAnimal() {
        int i = 0;
        while (i < 10) {
            randomAnimal();
            i++;
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

