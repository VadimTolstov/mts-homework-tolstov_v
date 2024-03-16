package ru.mts.hw5.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.hw5.exception.InvalidAnimalException;
import ru.mts.hw5.pets.Dog;
import ru.mts.hw5.predators.Wolf;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

class SearchServiceTest {
    private final SearchService searchService = mock(SearchServiceImpl.class);
    private final Dog dogLeapYear = new Dog("Немецкая", "Рекс", 77.21, "Злюка", LocalDate.of(2024, 3, 13));
    private final Wolf wolf = new Wolf("Лесной", "Бим", 88.21, "Добрый", LocalDate.of(1997, 10, 1));


    @Test
    @DisplayName("Выкидываем InvalidAnimalException передав null")
    void checkInvalidAnimalException() {
        doThrow(InvalidAnimalException.class).when(searchService).checkLeapYearAnimal(null);
    }

    @Test
    @DisplayName("Передаем животное с високосным годом")
    void checkLeapAnimalLeapYear() {
        doNothing().when(searchService).checkLeapYearAnimal(dogLeapYear);
        searchService.checkLeapYearAnimal(dogLeapYear);
        verify(searchService, times(1)).checkLeapYearAnimal(dogLeapYear);
    }

    @Test
    @DisplayName("Передаем животное с не високосным годом")
    void checkAnimalNotLeapYear() {
        doNothing().when(searchService).checkLeapYearAnimal(wolf);
        searchService.checkLeapYearAnimal(wolf);
        verify(searchService, times(1)).checkLeapYearAnimal(wolf);
    }
}