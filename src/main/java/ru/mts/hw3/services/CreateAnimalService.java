package ru.mts.hw3.services;

import ru.mts.hw3.pets.Cat;
import ru.mts.hw3.pets.Dog;
import ru.mts.hw3.predators.Shark;
import ru.mts.hw3.predators.Wolf;

import java.util.List;
import java.util.Random;

public interface CreateAnimalService {

    List<String> charactersList = List.of("Злой", "Добрый", "Нейтральный");
    List<String> nameList = List.of("Валера", "Зоя", "Анатолий", "Федя", "Анна");
    List<String> breedList = List.of("Итальянская", "Русская", "Американская", "Немецкая");

    default void randomAnimal() {
        switch (new Random().nextInt(1, 5)) {
            case 1:
                System.out.println(new Shark(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList)));
                break;
            case 2:
                System.out.println(new Wolf(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList)));
                break;
            case 3:
                System.out.println(new Dog(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList)));
                break;
            case 4:
                System.out.println(new Cat(randomSpecifications(breedList), randomSpecifications(nameList), randomPrice(), randomSpecifications(charactersList)));
                break;
            default:
                System.out.println("Что-то пошло не так");
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

