package ru.mts.hw5.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mts.hw5.AbstractAnimal;
import ru.mts.hw5.Animal;
import ru.mts.hw5.pets.Cat;
import ru.mts.hw5.pets.Dog;
import ru.mts.hw5.predators.Wolf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalRepositoryTest {
    @Mock
    AnimalRepository animalRepositoryMoc;
    private Animal[] animals;
    Animal[] animalNull = null;

    List<AbstractAnimal> abstractAnimalList;
    private final AnimalRepository animalRepository = new AnimalsRepositoryImpl();

    @BeforeEach
    void setUp() {
        abstractAnimalList = new ArrayList<>();
        animals = new Animal[20];
        for (int i = 0; i < 10; i++) {
            Dog dog = Dog.builder()
                    .breed("Немецкая")
                    .name("Рекс" + i)
                    .cost(77.21 + i)
                    .character("Злюка")
                    .birthDate(LocalDate.of(2000, 3, 13 + i))
                    .build();

            animals[i] = dog;

            abstractAnimalList.add(dog);
        }

        for (int i = 10; i < 20; i++) {
            Wolf wolf = Wolf.builder()
                    .breed("Лесной")
                    .name("Бим" + i)
                    .cost(88.21 + i)
                    .character("Добрый")
                    .birthDate(LocalDate.of(1990, 10, 1 + i))
                    .build();

            animals[i] = wolf;

            abstractAnimalList.add(wolf);
        }
    }

    @Test
    @DisplayName("Проверка на нет NullPointerException")
    void findLeapYearNamesNotNullPointerException() {
        assertDoesNotThrow(() -> animalRepository.findLeapYearNames(animalNull));
    }

    @Test
    @DisplayName("Проверка на наличие объекта с високосным годом и отсутствие объекта с не високосным годом в  Map<String, LocalDate>")
    void findLeapYearNames() {
        assertEquals(LocalDate.of(2000, 3, 14), animalRepository.findLeapYearNames(animals).get("Dog Рекс1"));
        assertNotEquals(LocalDate.of(1997, 10, 1), animalRepository.findLeapYearNames(animals).get("Wolf Бим"));
    }

    @Test
    @DisplayName("Проверка что в Map<String, LocalDate> добавлены объекты  високосным годом определенное количество")
    void findLeapYearNamesNumberObjects() {
        assertEquals(10, animalRepository.findLeapYearNames(animals).size());
    }

    @Test
    @DisplayName("Проверка что в Map<String, LocalDate> есть данный объект и он != null ")
    void findLeapYearNamesObjectsKeyNotNull() {
        Map<String, LocalDate> findLeapYearNamesMap = animalRepository.findLeapYearNames(animals);
        assertTrue(findLeapYearNamesMap.containsKey("Dog Рекс2") && findLeapYearNamesMap.get("Dog Рекс2") != null);
    }

    @Test
    @DisplayName("Передана дата старше всех объектов, проверяем что вернется самый старый объект и он один")
    void findOlderAnimalOldest() {
        Cat cat = Cat.builder()
                .breed("Лесной")
                .name("Бим")
                .cost(88.21)
                .character("Добрый")
                .birthDate(LocalDate.of(1988, 10, 1))
                .build();
        animals[0] = cat;
        assertEquals(1, animalRepository.findOlderAnimal(animals, 100).size());
        assertEquals(36, animalRepository.findOlderAnimal(animals, 100).get(cat));
        int i = 0;
        assertTrue(animalRepository.findOlderAnimal(animals, 100).containsKey(cat));
    }

    @Test
    @DisplayName("Проверка на нет NullPointerException")
    void findOlderAnimalNotNullPointerException() {
        assertDoesNotThrow(() -> animalRepository.findOlderAnimal(animalNull, 20));
    }

    @Test
    @DisplayName("Проверяем что вернуться все объекты старше указанной даты ")
    void findOlderAnimal() {
        assertEquals(20, animalRepository.findOlderAnimal(animals, 20).size());
        assertEquals(10, animalRepository.findOlderAnimal(animals, 25).size());
    }

    @Test
    @DisplayName("Проверяем что вернулся Map ожидаемого размера")
    void findDuplicateMapExpectedSize() {
        assertEquals(2, animalRepository.findDuplicate(animals).size());//вернет 2 списка
    }

    @Test
    @DisplayName("Проверка на нет NullPointerException")
    void findDuplicateNotNullPointerException() {
        assertDoesNotThrow(() -> animalRepository.findDuplicate(animalNull));
    }

    @Test
    @DisplayName("Проверяем получения значения по ключу")
    void findDuplicateMapExpected() {
        assertEquals(10, animalRepository.findDuplicate(animals).get("Dog").size());
        Cat cat = Cat.builder()
                .breed("Лесной")
                .name("Бим")
                .cost(88.21)
                .character("Добрый")
                .birthDate(LocalDate.of(1991, 10, 1))
                .build();
        animals[0] = cat;
        assertEquals(1, animalRepository.findDuplicate(animals).get("Cat").size());
        assertEquals(3, animalRepository.findDuplicate(animals).size());
        assertTrue(animalRepository.findDuplicate(animals).containsKey("Cat"));
    }

    @Test
    @DisplayName("Проверяем что вернется 3 объекта")
    void findMinConstAnimalsSize() {
        assertEquals(3, animalRepository.findMinConstAnimals(abstractAnimalList).size());
    }

    @Test
    @DisplayName("Проверяем что вернется 3 животного отсортированный в обратном порядке и с самой низкой ценой")
    void findMinConstAnimalsSorted() {
        assertEquals("Рекс2", animalRepository.findMinConstAnimals(abstractAnimalList).get(0));
        assertEquals("Рекс1", animalRepository.findMinConstAnimals(abstractAnimalList).get(1));
        assertEquals("Рекс0", animalRepository.findMinConstAnimals(abstractAnimalList).get(2));

        abstractAnimalList.add(Cat.builder()
                .breed("Лесной")
                .name("Альфа")
                .cost(0.00)
                .character("Добрый")
                .birthDate(LocalDate.of(1991, 10, 1))
                .build());
        assertEquals("Альфа", animalRepository.findMinConstAnimals(abstractAnimalList).get(2));
    }

    @Test
    @DisplayName("Проверяем что вернется 10 объектов")
    void findOldAndExpensiveSize() {
        assertEquals(10, animalRepository.findOldAndExpensive(abstractAnimalList).size());

    }

    @Test
    @DisplayName("Проверяем что список отсортировано по возрастанию даты")
    void findOldAndExpensiveSortedDate() {
        assertEquals(LocalDate.of(1990, 10, 11)
                , animalRepository.findOldAndExpensive(abstractAnimalList).get(0).getBirthDate());

        assertEquals(LocalDate.of(1990, 10, 20)
                , animalRepository.findOldAndExpensive(abstractAnimalList).get(9).getBirthDate());

        abstractAnimalList.add(Cat.builder()
                .breed("Лесной")
                .name("Альфа")
                .cost(200.00)
                .character("Добрый")
                .birthDate(LocalDate.of(1888, 10, 15))
                .build());

        assertEquals("Альфа", animalRepository.findOldAndExpensive(abstractAnimalList).get(0).getName());
    }

    @Test
    @DisplayName("Проверяем что списке нет младше 6 лет")
    void findOldAndExpensiveSortedYea() {
        abstractAnimalList.add(Cat.builder()
                .breed("Лесной")
                .name("Альфа")
                .cost(200.00)
                .character("Добрый")
                .birthDate(LocalDate.of(2023, 10, 1))
                .build());
        assertFalse(animalRepository.findOldAndExpensive(abstractAnimalList).stream()
                .anyMatch(animal -> animal.getName().equals("Альфа")));
    }

    @Test
    @DisplayName("Проверяем что списке нет объекта меньше средней стоимости")
    void findOldAndExpensiveSortedCost() {
        abstractAnimalList.add(Cat.builder()
                .breed("Лесной")
                .name("Альфа")
                .cost(10.00)
                .character("Добрый")
                .birthDate(LocalDate.of(1888, 10, 1))
                .build());
        assertFalse(animalRepository.findOldAndExpensive(abstractAnimalList).stream()
                .anyMatch(animal -> animal.getName().equals("Альфа")));
    }

    @Test
    @DisplayName("Проверяем я что метод findAverageAge был вызван с указанными параметрами")
    void findAverageAge() {
        doNothing().when(animalRepositoryMoc).findAverageAge(abstractAnimalList);
        animalRepositoryMoc.findAverageAge(abstractAnimalList);
        verify(animalRepositoryMoc, times(1)).findAverageAge(abstractAnimalList);
    }
}