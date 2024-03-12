package ru.mts.hw3.services;

import ru.mts.hw3.AbstractAnimal;
import ru.mts.hw3.pets.Cat;
import ru.mts.hw3.pets.Dog;
import ru.mts.hw3.predators.Shark;
import ru.mts.hw3.predators.Wolf;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public interface CreateAnimalService {

    List<String> charactersList = List.of("Злой", "Добрый", "Нейтральный");
    List<String> nameList = List.of("Валера", "Зоя", "Анатолий", "Федя", "Анна");
    List<String> breedList = List.of("Итальянская", "Русская", "Американская", "Немецкая");

    default void randomAnimal()  {
        switch (new Random().nextInt(1, 5)) {
            case 1:
                Shark shark = new Shark(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList));
                System.out.println(shark);
                break;
            case 2:
                Wolf wolf = new Wolf(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList));
                System.out.println(wolf);
                break;
            case 3:
                Dog dog = new Dog(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList));
                System.out.println(dog);
                break;
            case 4:
                Cat cat = new Cat(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList));
                System.out.println(cat);
                break;
        }
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

}

