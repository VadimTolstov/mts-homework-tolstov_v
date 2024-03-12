package ru.mts.hw5.exception;

import java.lang.reflect.InvocationTargetException;

public class InvalidAnimalBirthDateException extends InvocationTargetException {
    public InvalidAnimalBirthDateException(String message) {
        System.out.println(message);    }
}
