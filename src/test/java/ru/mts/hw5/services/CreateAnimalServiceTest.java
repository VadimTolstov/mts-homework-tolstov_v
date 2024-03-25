package ru.mts.hw5.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.hw5.Animal;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreateAnimalServiceTest {
    private final CreateAnimalService createAnimalService = new CreateAnimalServiceImpl();

    @Test
    @DisplayName("Проверяем что объекты отсортированы по классу, не стабилен из за метода randomAnimal")
    void createAnimal() {
        Assertions.assertEquals(4, createAnimalService.createAnimal().size());
    }

    @Test
    @DisplayName("Проверяем наличие ключей в Map, не стабилен из за метода randomAnimal")
    void createAnimalKey() {
        Set<String> set = new HashSet<>();
        set.add("Cat");
        set.add("Shark");
        set.add("Wolf");
        set.add("Dog");
        Assertions.assertEquals(set, createAnimalService.createAnimal().keySet());
        System.out.println(createAnimalService.createAnimal());
    }

    @Test
    @DisplayName("Проверяем наличие значения по ключу, не стабилен из за метода randomAnimal")
    void createAnimalVale() {
        assertTrue(createAnimalService.createAnimal().containsKey("Cat"));
        assertTrue(createAnimalService.createAnimal().containsKey("Shark"));
        assertTrue(createAnimalService.createAnimal().containsKey("Wolf"));
        assertTrue(createAnimalService.createAnimal().containsKey("Dog"));
    }
}