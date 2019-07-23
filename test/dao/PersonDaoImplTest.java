package dao;

import Conversion.DBObjectToBean;
import Conversion.RowCursor;
import bean.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.junit.Test;
import util.MongoDBTemplate;

import java.util.List;

public class PersonDaoImplTest {

    MongoDBTemplate mongoDBTemplate = new MongoDBTemplate();
    PersonDao personDao = new PersonDaoImpl();

    @Test
    public void addPerson() {
        Person person = new Person("fsj2", "110", "女", "5161", "zzdx", "1110");
        DBObject add = new BasicDBObject();
        add.put("name", person.getName());
        add.put("phoneNumber", person.getPhoneNumber());
        add.put("sex", person.getSex());
        add.put("email", person.getEmail());
        add.put("address", person.getAddress());
        add.put("birthday", person.getBirthday());

        mongoDBTemplate.addPerson(add);

    }

    @Test
    public void selectPersonById() {
        Person person = new Person("5ca6f83599b3bdfef7ccc7c5");
        DBObject dbObject = new BasicDBObject();
        dbObject.put("_id", new ObjectId(person.getId()));
        RowCursor<Person> rowCursor = new DBObjectToBean();
        mongoDBTemplate.selectPerson(rowCursor, dbObject);
        System.out.println(person);
    }

    @Test
    public void deletePerson() {
        Person person = new Person("5ca6f83599b3bdfef7ccc7c5");
        personDao.deletePerson(person);
    }

    @Test
    public void updatePerson() {
        Person person = new Person("5ca4194999b3393e5b57c029", "fsj3", "110", "女", "5161", "zzdx", "1110");
        personDao.updatePerson(person);
        System.out.println(person);
    }


    @Test
    public void selectPersons() {
        List<Person> personList = personDao.selectPersons();
        System.out.println(personList);
    }
}
