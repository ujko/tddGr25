package daoExample.dao;

import daoExample.model.Person;
import daoExample.utils.CsvUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PersonDaoCsvImpl implements PersonDao {

    private Map<Integer, Person> personMap;

    public PersonDaoCsvImpl() {
        try {
            personMap = CsvUtils.loadCsvFileToMap();
        } catch (IOException e) {
            System.exit(1);
        }
    }

    PersonDaoCsvImpl(Map<Integer, Person> map){
        this.personMap = map;
    }

    @Override
    public Person getPersonById(int personId) {
        return personMap.get(personId);
    }

    @Override
    public List<Person> getPersonByFirstName(String firstName) {
        return getAllPersons()
                .stream()
                .filter(person -> person.getFirstName().toLowerCase().contains(firstName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getPersonByLastName(String lastName) {
        return getAllPersons()
                .stream()
                .filter(person -> person.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getPersonByEmail(String email) {
        return getAllPersons()
                .stream()
                .filter(person -> person.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getPersonByIp(String ip) {
        return getAllPersons()
                .stream()
                .filter(person -> person.getIpAddress().toLowerCase().contains(ip.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getAllPersons() {
        return new ArrayList<>(personMap.values());
    }

    @Override
    public void addPerson(Person person) {
        person.setId(generateID());
        personMap.put(person.getId(),person);
        CsvUtils.saveToFile(getAllPersons());
    }

    private int generateID() {
        Set<Integer> set = new TreeSet<>(personMap.keySet());
        int i = 1;
        for (int id : set) {
            if (id != i) {
                return i;
            }
            i++;
        }
        return i;
    }

    @Override
    public void modifyPerson(Person person) {
        Person tmp = personMap.get(person.getId());
        if (person==null || tmp == null) {
            return;
        }
        if (person.getFirstName()!=null) {
            tmp.setFirstName(person.getFirstName());
        }
        if (person.getLastName()!=null) {
            tmp.setLastName(person.getLastName());
        }
        if (person.getEmail()!=null) {
            tmp.setEmail(person.getEmail());
        }
        if (person.getGender()!=null) {
            tmp.setGender(person.getGender());
        }
        if (person.getIpAddress()!=null) {
            tmp.setIpAddress(person.getIpAddress());
        }
        CsvUtils.saveToFile(getAllPersons());
    }

    @Override
    public void removePerson(int personId) {
        personMap.remove(personId);
        CsvUtils.saveToFile(getAllPersons());
    }
}
