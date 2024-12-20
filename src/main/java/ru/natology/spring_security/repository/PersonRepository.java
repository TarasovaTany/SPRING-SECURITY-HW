package ru.natology.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.natology.spring_security.entity.Person;
import ru.natology.spring_security.entity.PersonId;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAge(int age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
