package org.example.lab5.services.impl;

import org.example.lab5.models.Person;
import org.example.lab5.repositories.PersonRepository;
import org.example.lab5.services.Iservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements Iservices<Person,Long> {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean save(Person entity) {
        return personRepository.save(entity) != null;
    }

    @Override
    public boolean delete(Long id) {
        personRepository.deleteById(String.valueOf(id));
        return true;
    }

    @Override
    public boolean update(Person entity) {
        return personRepository.save(entity) != null;
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

}
