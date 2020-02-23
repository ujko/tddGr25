package daoExample;

import daoExample.dao.PersonDao;
import daoExample.model.Person;
import daoExample.model.PersonDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;


@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    PersonDao personDao;

    @InjectMocks
    PersonService personService;

    private Map<Integer, Person> initPersonMap() {
        Person personMockedOne = new Person()
                .setId(50)
                .setFirstName("Ania")
                .setLastName("Kowalska")
                .setGender("FEMALE");

        Person personMockedTwo = new Person()
                .setId(10)
                .setFirstName("Ola")
                .setLastName("Nowak")
                .setGender("FEMALE");
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(50,personMockedOne);
        personMap.put(10,personMockedTwo);
        return personMap;

    }
    private List<Person> getPersonList(){
        return new ArrayList<>(initPersonMap().values());
    }


    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllPersons() {
        Mockito.when(personDao.getAllPersons()).thenReturn(getPersonList());
        Assertions.assertThat(personService.getAllPersons()).hasSize(getPersonList().size());
    }

    @Test
    void getAllPersons_test2(){
        Mockito.when(personDao.getAllPersons()).thenReturn(getPersonList());
        Assertions.assertThat(personService.getAllPersons())
                .first()
                .isEqualToComparingFieldByField(new PersonDTO(50,"Ania Kowalska","FEMALE"));
    }
    @Test
    void getAllPerson_test3(){
        Mockito.when(personDao.getAllPersons()).thenThrow(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> personService.getAllPersons())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getAllPerson_test4(){
        Mockito.when(personDao.getAllPersons()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> personService.getAllPersons())
                .isInstanceOf(NullPointerException.class);
    }
    @Test
    void getAllPerson_test5(){
        Mockito.when(personDao.getAllPersons()).thenReturn(Collections.EMPTY_LIST);
        Assertions.assertThat(personService.getAllPersons()).isEmpty();
    }
    @Test
    void convertPersonDTOtoPerson_test1(){
        PersonDTO given=new PersonDTO(1,"Ania Kowalska","FEMALE");
        Person expected=new Person()
                .setId(1)
                .setFirstName("Ania")
                .setLastName("Kowalska")
                .setGender("FEMALE");

        Assertions.assertThat(personService.convertPersonDTOToPerson(given))
                .isEqualToComparingFieldByField(expected);
    }
    @Test
    void convertPersonDTOtoPerson_test2(){
        PersonDTO given=new PersonDTO(1,"Kowalska","FEMALE");
        Person expected=new Person()
                .setId(1)
                .setLastName("Kowalska")
                .setGender("FEMALE");

        Assertions.assertThat(personService.convertPersonDTOToPerson(given))
                .isEqualToComparingFieldByField(expected);
    }
    @Test
    void convertPersonDTOtoPerson_test3(){
        PersonDTO given=new PersonDTO(1,"","FEMALE");
        Person expected=new Person()
                .setId(1)
                .setLastName("")
                .setGender("FEMALE");

        Assertions.assertThat(personService.convertPersonDTOToPerson(given))
                .isEqualToComparingFieldByField(expected);
    }
    @Test
    void convertPersonDTOtoPerson_test4(){
        PersonDTO given=null;
        Person expected=new Person();

        Assertions.assertThat(personService.convertPersonDTOToPerson(given))
                .isEqualToComparingFieldByField(expected);
    }
}