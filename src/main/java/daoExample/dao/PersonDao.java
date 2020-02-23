package daoExample.dao;

import daoExample.model.Person;

import java.util.List;

public interface PersonDao {
    Person getPersonById(int personId);
    List<Person> getPersonByFirstName(String firstName);
    List<Person> getPersonByLastName(String lastName);
    List<Person> getPersonByEmail(String email);
    List<Person> getPersonByIp(String ip);
    List<Person> getAllPersons();
    void addPerson(Person person);
    void modifyPerson(Person person);
    void removePerson(int personId);
}
