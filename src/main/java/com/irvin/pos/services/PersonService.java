package com.irvin.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.irvin.pos.entities.Person;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.repositories.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    
    public Person createPerson(Person person) throws PropertyAlreadyExistException {
        if (personRepository.getByIdentification(person.getIdentification()) != null

        ) {
            throw new PropertyAlreadyExistException("identification", String.valueOf(person.getIdentification()));
        } else if (personRepository.getByPhoneNumber(person.getPhoneNumber()) != null) {
            throw new PropertyAlreadyExistException("phone_number", person.getPhoneNumber());
        } else if (personRepository.getByEmail(person.getEmail()) != null) {
            throw new PropertyAlreadyExistException("email", person.getEmail());
        }
        return personRepository.save(person);
    }
    
    public Person updatePerson(Person person){
        return personRepository.save(person);
    }

    public void deletePerson(long id){
        personRepository.deleteById(id);
    }

    public Page<Person> getAllPeople(){
        Page<Person> peoplePage =personRepository.findAll(PageRequest.of(0, 10));
        return peoplePage;
    }
}
