package ru.mts.hw5.services;

import ru.mts.hw5.AbstractAnimal;
import ru.mts.hw5.exception.InvalidAnimalException;

public class SearchServiceImpl implements SearchService {
    @Override
    public void checkLeapYearAnimal(AbstractAnimal animal) throws InvalidAnimalException {
        SearchService.super.checkLeapYearAnimal(animal);
    }
}
