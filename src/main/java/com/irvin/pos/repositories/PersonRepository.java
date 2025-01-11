package com.irvin.pos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irvin.pos.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}