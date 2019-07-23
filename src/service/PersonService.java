package service;

import bean.Person;

import java.util.List;

public interface PersonService {
    public int addPerson(Person person);//添加 联系人，返回值作为错误码

    public int updatePerson(Person person);//修改

    public boolean deletePerson(Person person);//删除

    public Person selectPersonById(Person person);//根据ID查询联系人

    public List<Person> selectAllPerson();//查询所有联系人
}
