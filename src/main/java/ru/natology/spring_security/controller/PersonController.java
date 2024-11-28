package ru.natology.spring_security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.natology.spring_security.entity.Person;
import ru.natology.spring_security.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersons(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getAge(@RequestParam("age") int age) {
        return service.getAge(age);
    }

    @GetMapping("/persons/by-fullname")
    public ResponseEntity<Person> getNameSurname(@RequestParam("name") String name,
                                                 @RequestParam("surname") String surname) {
        Optional<Person> person = service.getNameSurname(name, surname);
        return person.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}