package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    public  PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping(value ="/people")
    public ResponseEntity<Person>createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);
    }
    @GetMapping(value ="/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
    }
    @GetMapping(value = "/people/{id}")
    public ResponseEntity<Iterable<Person>>getPersonList(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK );
    }
    @PutMapping(value = "/people/{id}")
    public ResponseEntity<Person>updatePerson(@PathVariable Integer id, @RequestBody Person p){
        if(p.getId() != null)
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.OK);
        else
            return createPerson(p);
    }
    @DeleteMapping(value = "/people/{id}")
    public ResponseEntity DeletePerson(@PathVariable int id){
        personRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
