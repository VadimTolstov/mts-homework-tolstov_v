package lesson_5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)//показываем что будут моки
class ServiceTest {
    @Mock
    private DataHelper dataHelper;
    @InjectMocks
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
        assertEquals(runtimeException.getMessage(), "Первый параметр равен null");//проверяем ошибку переданную в Service
    }

    @Test
    void sumWithDefaultVale() {
        int result = service.sum(10, null);

        assertEquals(20, result);//проверяем ошибку переданную в Service
    }

    @Test
    void sumWithDataHelper() {
        when(dataHelper.checkForInteger(anyInt()))//мокаем данные e dataHelper.check anyInt() Любой результат
                .thenReturn(100);//возвращяем обьект

        int result = service.sum(100, 10);

        assertEquals(110, result);
    }

    @Test
    void sumWithDataHelperException() {
        when(dataHelper.check(anyInt()))//мокаем данные e dataHelper.check anyInt() Любой результат
                .thenThrow(RuntimeException.class);//возвращяем обьект
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> service.sum(100, 10));
        assertEquals("Произошла ошибка при обращениее dataHelper", runtimeException.getMessage());
    }
}