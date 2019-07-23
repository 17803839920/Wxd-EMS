package servlet;

import bean.Person;
import org.junit.Test;
import service.PersonService;
import util.ApplicationContext;

import java.util.List;


public class QueryAllPersonTest {


    @Test
    public void service() {
        ApplicationContext<PersonService> ac = new ApplicationContext<PersonService>();
        PersonService ps = ac.getBean("PersonService");
        List<Person> persons = ps.selectAllPerson();
        System.out.println(persons);

    }
}
