package ru.mts.hw5.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.hw5.Animal;
import ru.mts.hw5.pets.Cat;
import ru.mts.hw5.pets.Dog;
import ru.mts.hw5.predators.Wolf;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryTest {
    private Animal[] animals;
    Animal[] animalNull = null;
    private final AnimalRepository animalRepository = new AnimalsRepositoryImpl();

    @BeforeEach
    void setUp() {
        animals = new Animal[20];
        for (int i = 0; i < 10; i++) {
            animals[i] = Dog.builder()
                    .breed("Немецкая")
                    .name("Рекс" + i)
                    .cost(77.21)
                    .character("Злюка")
                    .birthDate(LocalDate.of(2000, 3, 13 + i))
                    .build();
        }
        for (int i = 10; i < 20; i++) {
            animals[i] = Wolf.builder()
                    .breed("Лесной")
                    .name("Бим" + i)
                    .cost(88.21)
                    .character("Добрый")
                    .birthDate(LocalDate.of(1997, 10, 1 + i))
                    .build();
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
                .birthDate(LocalDate.of(1991, 10, 1))
                .build();
        animals[0] = cat;
        assertEquals(1, animalRepository.findOlderAnimal(animals, 1900).size());
        assertEquals(1991, animalRepository.findOlderAnimal(animals, 1900).get(cat));
        assertTrue(animalRepository.findOlderAnimal(animals, 1900).containsKey(cat));
    }

    @Test
    @DisplayName("Проверка на нет NullPointerException")
    void findOlderAnimalNotNullPointerException() {
        assertDoesNotThrow(() -> animalRepository.findOlderAnimal(animalNull, 1900));
    }

    @Test
    @DisplayName("Проверяем что вернуться все объекты старше указанной даты ")
    void findOlderAnimal() {
        assertEquals(20, animalRepository.findOlderAnimal(animals, 2012).size());
        assertEquals(10, animalRepository.findOlderAnimal(animals, 2000).size());
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
        assertEquals(10, animalRepository.findDuplicate(animals).get("Dog"));
        Cat cat = Cat.builder()
                .breed("Лесной")
                .name("Бим")
                .cost(88.21)
                .character("Добрый")
                .birthDate(LocalDate.of(1991, 10, 1))
                .build();
        animals[0] = cat;
        assertEquals(1, animalRepository.findDuplicate(animals).get("Cat"));
        assertEquals(3, animalRepository.findDuplicate(animals).size());
        assertTrue(animalRepository.findDuplicate(animals).containsKey("Cat"));
    }
}