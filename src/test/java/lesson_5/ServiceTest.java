package lesson_5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)//показываем что будут моки
class ServiceTest {
    @Mock//мокаем DataHelper
    private DataHelper dataHelper;
    @InjectMocks
//Применяем мок. @InjectMocks -она обозначит что в Service будут добавлены все классы которые указаны как @Mock
    private Service service;

    @Test
    void sum() {
        int result = service.sum(1, 2);
        assertEquals(3, result);
        assertNotEquals(5, result);
    }

    @Test
    void sumException() {//Проверка на Exception
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> service.sum(null, 2));
        assertEquals(runtimeException.getMessage(), "Первый параметр равен null");//проверяем ошибку, переданную в Service
    }

    @Test
    void sumWithDefaultVale() {
        int result = service.sum(10, null);
        assertEquals(20, result);
    }

    @Test
    void sumWithDataHelper() {//мокаем данные
        when(dataHelper.checkForInteger(anyInt()))//мокаем данные e dataHelper.check anyInt()- Любой результат
                .thenReturn(100);//возвращаем объект

        int result = service.sum(100, 10);

        assertEquals(110, result);
    }

    @Test
    void sumWithDataHelperException() {//мокаем RuntimeException
        when(dataHelper.checkForInteger(anyInt()))//
                .thenThrow(RuntimeException.class);//возвращяем обьект
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> service.sum(100, 10));
        assertEquals("Произошла ошибка при обращение к dataHelper", runtimeException.getMessage());
    }

    @ParameterizedTest
    @MethodSource("fetchData")
    void parametezraziedTests(Request request, int expectedResult) {
        int actualResult = service.sum2(request);
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> fetchData() {
        return Stream.of(
                Arguments.arguments(new Request(10, 10), 20),
                Arguments.arguments(new Request(100, 100), 200),
                Arguments.arguments(new Request(100, 200), 300),
                Arguments.arguments(new Request(1000, 2000), 3000));
    }
}