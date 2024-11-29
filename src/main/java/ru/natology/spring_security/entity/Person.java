package ru.natology.spring_security.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@IdClass(PersonId.class)
@Table(name = "PERSONS")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Person {
    @Id
    @Column(length = 50)
    private String name;

    @Id
    @Column(length = 50)
    private String surname;

    @Id
    private int age;

    @Column(name = "phone_number", length = 25)
    private String phoneNumber;

    @Column(name = "city_of_living", length = 100)
    private String cityOfLiving;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Person person = (Person) o;
        return age == person.age && name.equals(person.name)
                && surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
