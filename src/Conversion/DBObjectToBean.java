package Conversion;

import bean.Person;
import com.mongodb.DBObject;

public class DBObjectToBean implements RowCursor<Person> {
    @Override
    public Person cursorRow(DBObject dbObject) {

        Person person = null;
        try {
            person = new Person();
            person.setId(dbObject.get("_id").toString());
            person.setAddress((String) dbObject.get("address"));
            person.setBirthday((String) dbObject.get("birthday"));
            person.setEmail((String) dbObject.get("email"));
            person.setName((String) dbObject.get("name"));
            person.setPhoneNumber((String) dbObject.get("phoneNumber"));
            person.setSex((String) dbObject.get("sex"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }
}
