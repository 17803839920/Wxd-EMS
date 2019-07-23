package service;

import bean.Person;
import dao.PersonDao;
import util.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    //跟你据工厂类获取DAO实现对象
    private PersonDao pImpl = new ApplicationContext<PersonDao>().getBean("PersonDao");

    //添加联系人√
    @Override
    public int addPerson(Person person) {
        try {
            if (person.getName() == null || "".equals(person.getName())) {
                return 1;
            }
            if (person.getPhoneNumber().length() != 11) {
                return 2;
            }
            pImpl.addPerson(person);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //修改联系人信息√
    @Override
    public int updatePerson(Person person) {
        try {
            Person personId = pImpl.selectPersonById(person);//根据ID查询联系人
            if (personId == null) {//若联系人不存在，返回-1
                return -1;
            }
            if (person.getName() == null || "".equals(person.getName())) {
                return 1;
            }
            if (person.getPhoneNumber().length() != 11) {
                return 2;
            }
            pImpl.updatePerson(person);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //删除联系人√
    @Override
    public boolean deletePerson(Person person) {
        try {
            Person personId = pImpl.selectPersonById(person);//根据ID查询联系人
            if (personId == null) {//若联系人不存在，返回-1
                return false;
            }
            //若联系人存在
            pImpl.deletePerson(person);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //根据ID查询联系人，用来显示联系人详细信息√
    @Override
    public Person selectPersonById(Person person) {
        Person p = pImpl.selectPersonById(person);

        return p;
    }

    //查询所有联系人√
    @Override
    public List<Person> selectAllPerson() {
        List<Person> personList = new ArrayList<Person>();
        personList = pImpl.selectPersons();
        return personList;
    }
}
