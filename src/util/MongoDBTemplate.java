package util;

import Conversion.RowCursor;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;

public class MongoDBTemplate<T> {
    /**
     * mongo:连接mongodb的服务器
     * db 获取数据库
     * dbCollection 获取y用户库中的集合
     */

    DBCollection dbCollection = MongoUtil.getMongodbConnection();

    /**
     * 向数据库中添加一个联系人
     */
    public void addPerson(DBObject dbObject) {
        dbCollection.insert(dbObject);
    }

//    /**
//     *  向数据库中添加一列联系人
//     */
//    public void addPsersons(List<DBObject> dbObjectList){
//        dbCollection.insert(dbObjectList);
//    }

    /**
     * 数据库中删除一个联系人
     */
    public void deletePerson(DBObject dbObject) {
        dbCollection.remove(dbObject);
    }

    /**
     * 数据库中更新一个联系人
     */
    public void updatePerson(DBObject queryObject, DBObject setCondition) {
        dbCollection.update(queryObject, setCondition, false, true);
    }

    /**
     * 数据库中查询一个联系人
     */
    public T selectPerson(RowCursor<T> rowCursor, DBObject dbObject) {
        T t = null;
        DBCursor dbCursor = dbCollection.find(dbObject);
        while (dbCursor.hasNext()) {
            DBObject db = dbCursor.next();
            t = rowCursor.cursorRow(db);
        }
        return t;
    }

    /**
     * 数据库中查询一列联系人
     */
    public List<T> selectPersons(RowCursor<T> rowCursor, DBObject dbObject) {
        T t = null;
        List<T> list = new ArrayList<>();
        DBCursor dbCursor = dbCollection.find(dbObject);
        while ((dbCursor.hasNext())) {
            DBObject db = dbCursor.next();
            t = rowCursor.cursorRow(db);
            list.add(t);
        }
        return list;
    }
}
