package daoExample.dao;

import daoExample.model.Person;
import daoExample.utils.CsvUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.runners.RunnerFactory;
import org.mockito.internal.runners.util.RunnerProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoCsvImplTest {



    PersonDao personDaoMocked;

    @BeforeEach
    void setUp() {


    }

    private Map<Integer, Person> initPersonMap() {
        Person personMockedOne = new Person()
                .setId(50)
                .setFirstName("Ania")
                .setLastName("Kowalska");
        Person personMockedTwo = new Person()
                .setId(10)
                .setFirstName("Ola")
                .setLastName("Nowak");
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(50,personMockedOne);
        personMap.put(10,personMockedTwo);
        return personMap;

    }

    @Test
    void getPersonById() {
        PersonDao personDao = new PersonDaoCsvImpl(initPersonMap());
        Assertions.assertThat(personDao.getPersonById(50)).isEqualToComparingOnlyGivenFields
                (new Person()
                        .setId(50)
                        .setFirstName("Ania")
                        .setLastName("Kowalska")
                        ,"id","firstName","lastName");
    }

    @Test
    void getPersonByFirstName() throws IOException {
//        PowerMockito.mockStatic(CsvUtils.class);
//        BDDMockito.given(CsvUtils.loadCsvFileToMap()).willReturn(initPersonMap());
//        personDaoMocked = new PersonDaoCsvImpl();
//        Assertions.assertThat(personDaoMocked.getPersonByFirstName("Ola")).hasSize(1);
    }

    @Test
    void getPersonByLastName() {
    }

    @Test
    void getPersonByEmail() {
    }

    @Test
    void getPersonByIp() {
    }

    @Test
    void getAllPersons() {
    }

    @Test
    void addPerson() {
    }

    @Test
    void modifyPerson() {
    }

    @Test
    void removePerson() {
    }
}