package dao;

import bean.User;
import com.mongodb.*;

public class UserDaoImpl implements UserDao {

    /**
     * mongo:连接mongodb的服务器
     * db 获取数据库
     * dbCollection 获取y用户库中的集合
     */
    private Mongo mongo;
    private DB db;
    private DBCollection dbCollection;

    private void init() throws Exception {
        mongo = new Mongo("127.0.0.1", 27017);
        db = mongo.getDB("baizhi");
        dbCollection = db.getCollection("user");
    }

    /**
     * 数据的查询
     * db.users.find({name:"wxd",password:666666})
     * dbCollection.find()
     */
    public boolean findUser(User user) throws Exception {
        init();
        boolean isExit = false;
        DBObject dbObject = new BasicDBObject();
        dbObject.put("username", user.getUsername());
        dbObject.put("password", user.getPassword());
        DBCursor dbCursor = dbCollection.find(dbObject);
        if (dbCursor != null) {
            isExit = true;
        }
        return isExit;
    }


    /**
     * 测试数据的插入
     * db.users.insert({name:"wxd",password:666666})
     * dbCollection.insert()
     */

    public void insertUser(User user) throws Exception {
        init();
        DBObject dbObject = new BasicDBObject();
        dbObject.put("username", user.getUsername());
        dbObject.put("password", user.getPassword());
        dbCollection.insert(dbObject);
    }

    @Override
    public void updateUserPassword(User user) throws Exception {
        init();
        DBObject queryDbObject = new BasicDBObject();
        queryDbObject.put("username", user.getUsername());
        DBObject setCondition = new BasicDBObject();
        setCondition.put("password", user.getPassword());
        DBObject setDbObject = new BasicDBObject();
        setDbObject.put("$set", setCondition);
        dbCollection.update(queryDbObject, setDbObject, false, true);
    }
}
