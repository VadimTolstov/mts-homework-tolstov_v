package ru.mts.hw5.exception;

import ru.mts.hw5.AbstractAnimal;

import java.time.LocalDate;

public class InvalidAnimalException extends RuntimeException {
    public InvalidAnimalException() {
        System.out.println("На вход пришло некорректный объект животного " + LocalDate.now());
    }

    public InvalidAnimalException(String message) {
        super(message);
    }

//    public InvalidAnimalException(AbstractAnimal animal) {
//        try {
//            if (animal.getBirthDate() == null) {
//                throw new InvalidAnimalBirthDateException(animal);
//            }
//        } catch (InvalidAnimalBirthDateException e) {
//            System.out.println(e.getMessage());
//        } catch (InvalidAnimalException e) {
//            throw new InvalidAnimalException("Работа метода завершилось ошибкой ");
//        }
//    }
}
