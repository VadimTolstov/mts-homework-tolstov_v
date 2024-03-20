package ru.mts.hw5.services;

import ru.mts.hw5.Animal;

import java.time.LocalDate;
import java.util.Map;

public class AnimalsRepositoryImpl implements AnimalRepository {
    @Override
    public Map<String, LocalDate> findLeapYearNames(Animal[] animals) {
        return AnimalRepository.super.findLeapYearNames(animals);
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(Animal[] animals, int years) {
        return AnimalRepository.super.findOlderAnimal(animals, years);
    }

    @Override
    public Map<String, Integer> findDuplicate(Animal[] animals) {
        return AnimalRepository.super.findDuplicate(animals);
    }
}
