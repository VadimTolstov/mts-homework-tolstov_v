package ru.mts.hw5.exception;

import java.time.LocalDate;

public class InvalidAnimalException extends RuntimeException {
    public InvalidAnimalException() {
        System.out.println("На вход пришло некорректный объект животного " + LocalDate.now());
    }
}
