package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeservice")
public class PersonDb implements PersonDao {

  private static List<Person>  DB=new ArrayList<>();

  @Override
  public Optional<Person> getPersonById(UUID id) {
return DB.stream()
  .filter(person -> person.getId().equals(id))
  .findFirst();
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    return getPersonById(id)
      .map(p -> {
        int index = DB.indexOf(p);
        if (index >= 0) {
          DB.set(index, new Person(id, person.getName()));
          return 1;
        }
        return 0;
      })
      .orElse(0);
  }

  @Override
  public String deletePersonById(UUID id) {
Optional<Person> personPresent=getPersonById(id);
  if(personPresent.isEmpty()){
    return "The user is not found";
  }
  DB.remove(personPresent.get());
  return "Successfully deleted";
  }

  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(new Person(id,person.getName()));
    DB.forEach(item-> System.out.println(item));
    return 1;
  }

  @Override
  public List<Person> getPeople() {
    return DB;
  }
}

