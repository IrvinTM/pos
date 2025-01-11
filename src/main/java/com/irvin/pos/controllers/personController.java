package com.irvin.pos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irvin.pos.entities.Person;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.services.PersonService;

@RestController("/api/people")
public class personController {
    @Autowired
    private PersonService personService;
    
    @GetMapping("/")
    public Page<Person> getAllPeople(){
    return personService.getAllPeople();
    }
    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(Person person) throws PropertyAlreadyExistException{
        return ResponseEntity.ok(person);
    }




}
