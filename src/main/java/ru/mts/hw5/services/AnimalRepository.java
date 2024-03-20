package ru.mts.hw5.services;

import org.apache.commons.lang3.ArrayUtils;
import ru.mts.hw5.AbstractAnimal;
import ru.mts.hw5.Animal;

import java.time.LocalDate;
import java.util.*;

public interface AnimalRepository {
    default Map<String, LocalDate> findLeapYearNames(Animal[] animals) {
        Map<String, LocalDate> findLeapYearNamesMap = new HashMap<>();
        if (ArrayUtils.isNotEmpty(animals)) {
            for (Animal animal : animals) {
                if (((AbstractAnimal) animal).getBirthDate().isLeapYear()) {
                    findLeapYearNamesMap.put(animal.getClass().getSimpleName() + " " + animal.getName(),
                            ((AbstractAnimal) animal).getBirthDate());
                }
            }
        }
        return findLeapYearNamesMap;
    }

    default Map<Animal, Integer> findOlderAnimal(Animal[] animals, int years) {
        Map<Animal, Integer> findOlderAnimalMap = new HashMap<>();
        if (ArrayUtils.isNotEmpty(animals)) {
            for (int i = 0; i < animals.length; i++) {
                if (((AbstractAnimal) animals[i]).getBirthDate().getYear() < years) {
                    findOlderAnimalMap.put(animals[i], ((AbstractAnimal) animals[i]).getBirthDate().getYear());
                }
            }

            if (findOlderAnimalMap.isEmpty()) {
                AbstractAnimal[] array = new AbstractAnimal[animals.length];
                for (int i = 0; i < animals.length; i++) {
                    array[i] = (AbstractAnimal) animals[i];
                }
                Arrays.sort(array, new Comparator<AbstractAnimal>() {
                    @Override
                    public int compare(AbstractAnimal o1, AbstractAnimal o2) {
                        return o2.getBirthDate().getYear() - o1.getBirthDate().getYear();
                    }
                });
                findOlderAnimalMap.put(array[array.length - 1], array[array.length - 1].getBirthDate().getYear());
            }
        }
        return findOlderAnimalMap;
    }

    default Map<String, Integer> findDuplicate(Animal[] animals) {
        Map<String, Integer> findOlderAnimalMap = new HashMap<>();
        if (ArrayUtils.isNotEmpty(animals)) {
            boolean isListWasNotFound = true;
            List<List<Animal>> listAnimals = new ArrayList<>();
            List<Animal> list = new ArrayList<>(Arrays.asList(animals));
            Animal animal = list.get(0);
            List<Animal> refact = new ArrayList<>();
            refact.add(animal);
            listAnimals.add(refact);
            for (int i = 1; i < list.size(); i++) {
                animal = list.get(i);
                for (int j = 0; j < listAnimals.size(); j++) {
                    if (animal.getClass().getSimpleName().equals(listAnimals.get(j).get(0).getClass().getSimpleName())) {
                        listAnimals.get(j).add(animal);
                        isListWasNotFound = false;
                    }
                }
                while (isListWasNotFound) {
                    List<Animal> newList = new ArrayList<>();
                    newList.add(animal);
                    listAnimals.add(newList);
                    isListWasNotFound = false;
                }
                isListWasNotFound = true;
            }

            for (int i = 0; i < listAnimals.size(); i++) {
                findOlderAnimalMap.put(listAnimals.get(i).get(0).getClass().getSimpleName(), listAnimals.get(i).size());
            }

            System.out.println(findOlderAnimalMap);
        }
        return findOlderAnimalMap;
    }
}
