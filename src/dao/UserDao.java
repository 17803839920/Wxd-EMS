package dao;


import bean.User;

public interface UserDao {
    //查找用户
    public boolean findUser(User user) throws Exception;

    //插入用户
    public void insertUser(User user) throws Exception;

    //修改用户密码
    public void updateUserPassword(User user) throws Exception;
}
