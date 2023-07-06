package br.com.tech.test.srm.repository;

import br.com.tech.test.srm.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person save(Person entity);
}
