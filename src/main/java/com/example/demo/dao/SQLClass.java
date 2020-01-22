package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("sql")
public class SQLClass implements PersonDao{
  @Override
  public int insertPerson(UUID id, Person person) {
    return 0;
  }

  @Override
  public List<Person> getPeople() {
    return List.of(new Person(UUID.randomUUID(),"from sql db"));
  }

  @Override
  public Optional<Person> getPersonById(UUID id) {
    return Optional.empty();
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    return 0;
  }

  @Override
  public String deletePersonById(UUID id) {
    return null;
  }
}
