package ru.mts.hw5;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;
@EqualsAndHashCode
@AllArgsConstructor
@SuperBuilder
public abstract class AbstractAnimal implements Animal {
    @EqualsAndHashCode.Exclude
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    protected String breed; // порода
    protected String name; // имя
    protected Double cost; // цена в магазине
    protected String character; // характер
    @Getter
    protected LocalDate birthDate;

//    public AbstractAnimal(String breed, String name, Double cost, String character, LocalDate birthDate) {
//        this.breed = breed;
//        this.name = name;
//        this.cost = cost;
//        this.character = character;
//        this.birthDate = birthDate;
//    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AbstractAnimal that = (AbstractAnimal) o;
//        return Objects.equals(breed, that.breed) && Objects.equals(name, that.name) && Objects.equals(cost, that.cost) && Objects.equals(character, that.character) && Objects.equals(birthDate, that.birthDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(breed, name, cost, character, birthDate);
//    }

    @Override
    public String toString() {

        return "{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + dateTimeFormatter.format(birthDate) +
                '}';
    }

}
