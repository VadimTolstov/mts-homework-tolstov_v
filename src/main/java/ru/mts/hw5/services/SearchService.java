package ru.mts.hw5.services;

import ru.mts.hw5.AbstractAnimal;
import ru.mts.hw5.exception.InvalidAnimalException;

public interface SearchService {

    default void checkLeapYearAnimal(AbstractAnimal animal) throws InvalidAnimalException {
        if (animal.getBirthDate().isLeapYear()) {
            System.out.println(animal.getName() + " был(а) рожден(а) в високосный год");
        }
        if (!animal.getBirthDate().isLeapYear()) {
            System.out.println(animal.getName() + " не был(а) рожден(а) в високосный год");
        }
        if (animal == null) {
            throw new InvalidAnimalException();
        }
    }
}
