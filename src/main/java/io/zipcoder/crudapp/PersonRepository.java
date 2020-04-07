package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

//     Iterable<Person>findAll();
//
//     Person findOne(Integer id);
//
//     Person save(Person person);
//
//     void delete(Integer id);
}
