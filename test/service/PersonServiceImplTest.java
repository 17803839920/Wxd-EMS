package service;


import bean.Person;
import dao.PersonDao;
import org.junit.Test;
import util.ApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class PersonServiceImplTest {
    private PersonDao pImpl = new ApplicationContext<PersonDao>().getBean("PersonDao");

    @Test
    public void addPerson() {
        Person person = new Person("王旭东", "12345678912", "nan", "5161", "zzdx", "1110");
        try {
            if (person.getName() == null || "".equals(person.getName())) {
                System.out.println("````````");
            }
            if (person.getPhoneNumber().length() != 11) {
                System.out.println("````````");
            }
            pImpl.addPerson(person);
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("````````");
        }
    }

    @Test
    public void selectPersonById() {
        Person person = new Person("5ca6f9e899b380ccef48b9c5");
        Person p = pImpl.selectPersonById(person);
        System.out.println(p);
    }

    @Test
    public void updatePerson() {
        Person person = new Person("5ca41a5299b3198b26a49b00", "wxd9", "110", "女", "5161", "zzdx", "0911");
        pImpl.updatePerson(person);
        System.out.println(person);
    }

    @Test
    public void deletePerson() {
        Person person = new Person("5ca7079599b33430584c13c6");
        pImpl.deletePerson(person);
    }

    @Test
    public void selectAllPerson() {
        List<Person> personList = new ArrayList<Person>();
        personList = pImpl.selectPersons();
        System.out.println(personList);
    }
}
