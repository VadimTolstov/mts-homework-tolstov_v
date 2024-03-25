package ru.mts.hw5.services;

import org.apache.commons.lang3.ArrayUtils;
import ru.mts.hw5.AbstractAnimal;
import ru.mts.hw5.Animal;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalsRepositoryImpl implements AnimalRepository {
    @Override
    public Map<String, LocalDate> findLeapYearNames(Animal[] animals) {
        Map<String, LocalDate> stringLocalDateMap = new HashMap<>();
        if (ArrayUtils.isNotEmpty(animals)) {
            AbstractAnimal[] array = animalCasting(animals);
            stringLocalDateMap = Arrays.stream(array)
                    .filter(o1 -> o1.getBirthDate().isLeapYear())
                    .collect(Collectors.toMap(animal -> animal.getClass().getSimpleName() + " " + animal.getName(),
                            AbstractAnimal::getBirthDate));
        }
        return stringLocalDateMap;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(Animal[] animals, int years) {
        Map<Animal, Integer> animalIntegerMap = new HashMap<>();
        if (ArrayUtils.isNotEmpty(animals)) {
            AbstractAnimal[] array = animalCasting(animals);
            if (Arrays.stream(array).anyMatch(animal -> LocalDate.now().getYear() - animal.getBirthDate().getYear() > years)) {
                animalIntegerMap = Arrays.stream(array)
                        .filter(animal -> LocalDate.now().getYear() - animal.getBirthDate().getYear() > years)
                        .collect(Collectors.toMap(animal -> animal,
                                animal -> LocalDate.now().getYear() - animal.getBirthDate().getYear()));
            } else {
                animalIntegerMap = Arrays.stream(array)
                        .sorted(Comparator.comparingInt(o -> o.getBirthDate().getYear()))
                        .limit(1)
                        .collect(Collectors.toMap(animal -> animal,
                                animal -> LocalDate.now().getYear() - animal.getBirthDate().getYear()));
            }
        }
        return animalIntegerMap;
    }

    @Override
    public Map<String, List<Animal>> findDuplicate(Animal[] animals) {
        Map<String, List<Animal>> stringIntegerHashMap = new HashMap<>();
        if (ArrayUtils.isNotEmpty(animals)) {
            AbstractAnimal[] array = animalCasting(animals);
            stringIntegerHashMap = Arrays.stream(array)
                    .collect(Collectors
                    .groupingBy(animal -> animal.getClass().getSimpleName()));
        }
        return stringIntegerHashMap;
    }
}
