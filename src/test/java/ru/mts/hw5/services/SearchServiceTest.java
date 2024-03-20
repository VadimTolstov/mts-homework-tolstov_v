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
    private final Dog dogLeapYear = Dog.builder()
            .breed("Немецкая")
            .name("Рекс")
            .cost(77.21)
            .character("Злюка")
            .birthDate(LocalDate.of(2024, 3, 13))
            .build();
    private final Wolf wolf = Wolf.builder()
            .breed("Лесной")
            .name("Бим")
            .cost(88.21)
            .character("Добрый")
            .birthDate(LocalDate.of(1997, 10, 1))
            .build();


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