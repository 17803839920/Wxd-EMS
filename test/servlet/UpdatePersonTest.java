package servlet;

import bean.Person;
import org.junit.Test;
import service.PersonService;
import util.ApplicationContext;

public class UpdatePersonTest {


    @Test
    public void service() {
        ApplicationContext<PersonService> ac = new ApplicationContext<>();
        PersonService ps = ac.getBean("PersonService");

        Person person = new Person("5ca41a5299b3198b26a49b00", "wxd9", "110", "女", "5161", "zzdx", "0911");
        ps.updatePerson(person);
        System.out.println(person);
    }
}
