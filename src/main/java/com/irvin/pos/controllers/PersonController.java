package com.irvin.pos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.irvin.pos.entities.Person;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.services.PersonService;

@RestController("/api/people")
public class PersonController {
    @Autowired
    private PersonService personService;
    
    @GetMapping
    public Page<Person> getAllPeople(){
    return personService.getAllPeople();
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) throws PropertyAlreadyExistException{
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePerson(@RequestParam long id){
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        return ResponseEntity.ok(personService.updatePerson(person));
    }
}
