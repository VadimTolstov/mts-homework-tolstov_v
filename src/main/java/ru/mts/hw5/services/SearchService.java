package ru.mts.hw5.services;

import ru.mts.hw5.AbstractAnimal;
import ru.mts.hw5.exception.InvalidAnimalException;

public interface SearchService {

    default void checkLeapYearAnimal(AbstractAnimal animal) throws InvalidAnimalException {
        try {
            if (animal == null) {
                throw new InvalidAnimalException();
            }
        } catch (InvalidAnimalException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        if (animal.getBirthDate().isLeapYear()) {
            System.out.println(animal.getName() + " был(а) рожден(а) в високосный год");
        } else {
            System.out.println(animal.getName() + " не был(а) рожден(а) в високосный год");
        }
    }
}
