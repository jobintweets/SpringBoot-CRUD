package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
  private final PersonDao personDao;

//personDao is actually the interface

  @Autowired
  //basically a dependency injection.
  public PersonService( @Qualifier("fakeservice") PersonDao personDao) {
    this.personDao = personDao;
   }


  public int addPersontoDb(Person person){
    return personDao.insertPerson(person);
  }

  public List<Person> getPeople() {
    return  personDao.getPeople();
  }

  public Optional<Person> getSinglePerson(UUID id) {
    return  personDao.getPersonById(id);
  }
  public String deletePerson(UUID id) {
    return personDao.deletePersonById(id);
  }

  public int updatePerson(UUID id,Person person) {
    return  personDao.updatePersonById(id,person);
  }
}