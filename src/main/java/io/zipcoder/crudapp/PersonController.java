package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {


    public  PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {

        this.personRepository = personRepository;
    };

    @PostMapping//(value ="/people")
    public ResponseEntity<Person>createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Iterable<Person>>getPersonList(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK );
    }
    @PutMapping( "/{id}")
    public ResponseEntity<Person>updatePerson(@PathVariable Integer id, @RequestBody Person p){
        if(p.getId() != null)
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.OK);
        else
            return createPerson(p);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity DeletePerson(@PathVariable int id){
        personRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
