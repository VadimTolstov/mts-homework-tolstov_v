package ru.mts.hw3.services;

import ru.mts.hw3.pets.Cat;
import ru.mts.hw3.pets.Dog;
import ru.mts.hw3.predators.Shark;
import ru.mts.hw3.predators.Wolf;

import java.util.Random;

public interface CreateAnimalService {

    default void randomAnimal() {
        int i = new Random().nextInt(1, 5);
        switch (i) {
            case 1:
                System.out.println(new Shark("nameAnimal", "Валера", randomPrice(), "Злая"));
                break;
            case 2:
                System.out.println(new Wolf("Таёжный", "Серега", randomPrice(), "Средне"));
                break;
            case 3:
                System.out.println(new Dog("Дворняга", "Бим", randomPrice(), "Добрый"));
                break;
            case 4:
                System.out.println(new Cat("Чеширский", "Мурка", randomPrice(), "Не тральный"));
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

    private Double randomPrice() {
        return new Random().nextDouble(1, 100000);
    }
}

