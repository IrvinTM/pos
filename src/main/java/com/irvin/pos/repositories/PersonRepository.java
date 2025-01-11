package com.irvin.pos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irvin.pos.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    public Person getByIdentification(String identification);

    public Person getByPhoneNumber(String phoneNumber);

    public Person getByEmail(String email);
}