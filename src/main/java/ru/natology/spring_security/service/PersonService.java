package ru.natology.spring_security.service;

import java.util.List;
import java.util.Optional;

import ru.natology.spring_security.entity.Person;
import ru.natology.spring_security.repository.PersonRepository;

@org.springframework.stereotype.Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.findByCityOfLiving(city);
    }

    public List<Person> getAge(int age) {
        return repository.findByAgeLessThanOrderByAge(age);
    }

    public Optional<Person> getNameSurname(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }
}
