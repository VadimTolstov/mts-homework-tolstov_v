package ru.mts.hw5.services;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import ru.mts.hw5.AbstractAnimal;
import ru.mts.hw5.Animal;

import java.time.LocalDate;
import java.util.*;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

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
                if (LocalDate.now().getYear() - ((AbstractAnimal) animals[i]).getBirthDate().getYear() < years) {
                    findOlderAnimalMap.put(animals[i], LocalDate.now().getYear() - ((AbstractAnimal) animals[i]).getBirthDate().getYear());
                }
            }

            if (findOlderAnimalMap.isEmpty()) {
                AbstractAnimal[] array = animalCasting(animals);
                Arrays.sort(array, new Comparator<AbstractAnimal>() {
                    @Override
                    public int compare(AbstractAnimal o1, AbstractAnimal o2) {
                        return o2.getBirthDate().getYear() - o1.getBirthDate().getYear();
                    }
                });
                findOlderAnimalMap.put(array[array.length - 1], LocalDate.now().getYear() - array[array.length - 1].getBirthDate().getYear());
            }
        }
        return findOlderAnimalMap;
    }

    default Map<String, List<Animal>> findDuplicate(Animal[] animals) {
        Map<String, List<Animal>> findOlderAnimalMap = new HashMap<>();
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
                findOlderAnimalMap.put(listAnimals.get(i).get(0).getClass().getSimpleName(), listAnimals.get(i));
            }

            System.out.println(findOlderAnimalMap);
        }
        return findOlderAnimalMap;
    }

    default AbstractAnimal[] animalCasting(Animal[] animals) {
        AbstractAnimal[] array = new AbstractAnimal[animals.length];
        for (int i = 0; i < animals.length; i++) {
            array[i] = (AbstractAnimal) animals[i];
        }
        return array;
    }

    default void findAverageAge(List<AbstractAnimal> animals) {
        if (CollectionUtils.isNotEmpty(animals)) {
            animals.stream()
                    .mapToInt(animal -> LocalDate.now().getYear() - animal.getBirthDate().getYear())
                    .average()
                    .stream().forEach(System.out::println);
        }
    }

    default List<AbstractAnimal> findOldAndExpensive(List<AbstractAnimal> animals) {
        double coll = animals.stream()
                .mapToDouble(AbstractAnimal::getCost)
                .average()
                .orElseGet(() -> {
                    System.out.println("В findOldAndExpensive не смогли посчитать среднею стоимость, берем 0");
                    return 0;
                });
        return animals.stream()
                .sorted(Comparator.comparingInt(animal -> animal.getBirthDate().getYear()))
                .filter(animal -> ((LocalDate.now().getYear() - animal.getBirthDate().getYear()) > 5) && (animal.getCost() > coll))
                .toList();

    }

    default List<String> findMinConstAnimals(List<AbstractAnimal> animals) {
          return animals.stream()
                .sorted((o1, o2) -> o1.getCost().compareTo(o2.getCost()))
                .limit(3)
                .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
                .map(AbstractAnimal::getName)
                .toList();
    }
}
