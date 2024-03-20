package ru.mts;

import ru.mts.hw5.AbstractAnimal;
import ru.mts.hw5.exception.InvalidAnimalBirthDateException;
import ru.mts.hw5.services.CreateAnimalServiceImpl;
import ru.mts.hw5.services.SearchServiceImpl;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        System.out.println("что то получилось " + createAnimalService.createAnimal());

        AbstractAnimal abstractAnimal;
        SearchServiceImpl service = new SearchServiceImpl();
        try {
            for (int i = 0; i < 10; i++) {
                abstractAnimal = createAnimalService.randomAnimal();
                if (abstractAnimal.getBirthDate() == null) {
                    throw new InvalidAnimalBirthDateException("у животного" + abstractAnimal.getBreed() + " не указана дата его рождения");
                }
                service.checkLeapYearAnimal(abstractAnimal);
            }
        } catch (InvalidAnimalBirthDateException | NullPointerException e) {
            System.out.println("Работа метода завершилась ошибкой " + e.getMessage());
        }
    }
}