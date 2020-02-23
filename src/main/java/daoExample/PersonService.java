package daoExample;

import daoExample.dao.PersonDao;
import daoExample.model.Person;
import daoExample.model.PersonDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private PersonDao dao;

    public PersonService(PersonDao dao) {
        this.dao = dao;
    }

    public List<PersonDTO> getAllPersons() {
        List <Person> listFromPerson = dao.getAllPersons();
        return listFromPerson
                .stream()
                .map(person -> new PersonDTO(person.getId(),person.getFirstName() +" " + person.getLastName(), person.getGender()))
                .collect(Collectors.toList());
    }

    Person convertPersonDTOToPerson(PersonDTO personDTO) {
        Person person=new Person();
        if(personDTO==null){
            return person;
        }
        person.setId(personDTO.getId());
        String[] firstLastName=personDTO.getName().split("\\s");
        if(firstLastName.length==2){
            person.setFirstName(firstLastName[0]);
            person.setLastName(firstLastName[1]);
        } else{
            person.setLastName(firstLastName[0]);
        }
        person.setGender(personDTO.getGender());
        return person;
    }

    public void addPerson(PersonDTO personDTO) {
        dao.addPerson(convertPersonDTOToPerson(personDTO));
    }

    public Person getPersonById(int id) {
        return dao.getPersonById(id);
    }

}
