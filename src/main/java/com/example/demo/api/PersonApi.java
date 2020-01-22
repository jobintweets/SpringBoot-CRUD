package com.example.demo.api;

import com.example.demo.dao.PersonDb;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/person")
@RestController
//making it as a restful service
public class PersonApi {
  private  final PersonService personService;
  private final PersonDb personDb;

@Autowired
  public PersonApi(PersonService abc,PersonDb personDb) {
    this.personService = abc;
    this.personDb=personDb;
  }
  @PostMapping
  public List<Person> addPerson( @Valid @NotNull @RequestBody Person person) {
 personService.addPersontoDb(person);
 return personDb.getPeople();
}
@GetMapping
  public List<Person> getPeople() {
   return personService.getPeople();
  }

//  gets  the id's passed along the url
  @GetMapping(path = "{id}")
   public Optional<Person> getSinglePerson(@PathVariable("id") UUID id  ) {
  return  personService.getSinglePerson(id);
   }

   @DeleteMapping (path = "{id}")
  public  String deletePerson(@PathVariable("id") UUID id) {
  return  personService.deletePerson(id);
   }

   @PutMapping (path = "{id}")
   public  Optional<Person> updatePerson(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody  Person person){
   personService.updatePerson(id,person);
return personService.getSinglePerson(id);
   }

}
