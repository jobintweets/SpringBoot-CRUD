package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao   {

  //insert a new person into db with id
  int insertPerson(UUID id, Person person);

  //insert a person to db by generating his id
  default int  insertPerson(Person person) {
    UUID id=UUID.randomUUID();
    return insertPerson(id,person);
  }
  List<Person> getPeople();

  Optional<Person> getPersonById(UUID id);
  int updatePersonById(UUID id , Person person);
  String deletePersonById(UUID id);
}
