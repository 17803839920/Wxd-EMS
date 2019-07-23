package dao;

import Conversion.DBObjectToBean;
import Conversion.RowCursor;
import bean.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import util.MongoDBTemplate;

import java.util.List;


public class PersonDaoImpl implements dao.PersonDao {

    private MongoDBTemplate<Person> mongoDBTemplate = new MongoDBTemplate<>();

    //添加联系人√
    @Override
    public void addPerson(Person person) {
        DBObject add = new BasicDBObject();
        add.put("name", person.getName());
        add.put("phoneNumber", person.getPhoneNumber());
        add.put("sex", person.getSex());
        add.put("email", person.getEmail());
        add.put("address", person.getAddress());
        add.put("birthday", person.getBirthday());

        mongoDBTemplate.addPerson(add);
    }

    //删除联系人√
    @Override
    public void deletePerson(Person person) {
        if (person.getId() == null || person.getId().length() == 0) {
            System.out.println("没有这个人");
        }
        DBObject delete = new BasicDBObject();
        delete.put("_id", new ObjectId(person.getId()));
        mongoDBTemplate.deletePerson(delete);
    }

    //修改联系人信息√
    @Override
    public void updatePerson(Person person) {
        if (person.getId() == null || person.getId().length() == 0) {
            System.out.println("没有这个人");
        }
        DBObject querydbObject = new BasicDBObject();
        querydbObject.put("_id", new ObjectId(person.getId()));

        DBObject dbObject = new BasicDBObject();
        dbObject.put("name", person.getName());
        dbObject.put("phoneNumber", person.getPhoneNumber());
        dbObject.put("address", person.getAddress());
        dbObject.put("birthday", person.getBirthday());
        dbObject.put("email", person.getEmail());
        dbObject.put("sex", person.getSex());
        DBObject setCondition = new BasicDBObject();
        setCondition.put("$set", dbObject);
        mongoDBTemplate.updatePerson(querydbObject, setCondition);
    }

//    //根据姓名查询一个联系人
//    @Override
//    public Person selectPersonByName(Person person) {
//        DBObject dbObject = new BasicDBObject();
//        dbObject.put("name",  person.getName());
//        RowCursor<Person> rowCursor = new DBObjectToBean();
//        Person p = mongoDBTemplate.selectPerson(rowCursor,dbObject);
//        return p;
//    }

    //根据id查询一个联系人√
    @Override
    public Person selectPersonById(Person person) {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("_id", new ObjectId(person.getId()));
        RowCursor<Person> rowCursor = new DBObjectToBean();
        Person p = mongoDBTemplate.selectPerson(rowCursor, dbObject);
        return p;
    }

    //查询所有联系人√
    @Override
    public List<Person> selectPersons() {
        DBObject all = new BasicDBObject();
        RowCursor<Person> rowCursor = new DBObjectToBean();
        List<Person> personList = mongoDBTemplate.selectPersons(rowCursor, all);
        return personList;
    }


    //查询联系人列表7条数据

//    @Override
//    public List<Person> findPersions() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        List<Person> list = new ArrayList<>();
//        DBCursor dbCursor = dbCollection.find();
//        DBObject dbObject;
//        Person person = new Person();
//        while(dbCursor.hasNext()){
//            dbObject = dbCursor.next();
//            person = BeanUtils.dbObjectToBean(dbObject, person);
//            list.add(person);
//            System.out.println(person);
//        }
//        System.out.println(list);
//        return list;
//    }
}
