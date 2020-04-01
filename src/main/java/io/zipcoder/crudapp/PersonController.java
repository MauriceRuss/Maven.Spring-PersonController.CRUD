package io.zipcoder.crudapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @PostMapping("/people")
    Person createPerson(@RequestBody Person p){
        return null;
    }
    @GetMapping("/people/{id}")
    Person getPerson(@PathVariable int id) {
        return null;
    }
    @GetMapping("/people/{id}")
    List<Person> getPersonList(){
        return null;
    }
    @PutMapping("/people/{id}")
    Person updatePerson(@RequestBody Person p){
        return null;
    }
    @DeleteMapping("/people/{id}")
    void DeletePerson(@PathVariable int id){

    }
}
