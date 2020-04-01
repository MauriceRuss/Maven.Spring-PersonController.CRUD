package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;
import org.w3c.dom.stylesheets.LinkStyle;

public interface PersonRepository extends CrudRepository<Person, Integer> {

     Iterable<Person>findAll();

     Person findOne(Integer id);

     Person save(Person person);

     void delete(Integer id);
}
