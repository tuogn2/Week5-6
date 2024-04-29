package org.example.lab5.repositories;

import org.example.lab5.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    public Optional<Person> findByEmail(String email);
}