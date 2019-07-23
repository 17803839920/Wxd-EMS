package dao;

import bean.Person;

import java.util.List;

public interface PersonDao {
    public void addPerson(Person person) throws Exception;

    public void deletePerson(Person person);

    public void updatePerson(Person person);

    //public Person selectPersonByName(Person person);
    public Person selectPersonById(Person person);

    public List<Person> selectPersons();
}
