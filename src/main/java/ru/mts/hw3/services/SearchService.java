package ru.mts.hw3.services;

import ru.mts.hw3.AbstractAnimal;

public interface SearchService {

    default void checkLeapYearAnimal(AbstractAnimal animal) {
        if (animal.getBirthDate().isLeapYear()) {
            System.out.println(animal.getName() + " был(а) рожден(а) в високосный год");
        } else System.out.println(animal.getName() + " не был(а) рожден(а) в високосный год");
    }
}
