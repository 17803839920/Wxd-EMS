package util;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class MongoUtil {//JDBC工具类
    private static Properties properties = new Properties();//新建全局变量properties对象
    private static ThreadLocal<DBCollection> connectionThreadLocal = new ThreadLocal<>();
    //新建Threadlocal用于绑定线程

    static {
        //静态代码块中进行资源初始化
        InputStream inputStream = MongoUtil.class.getResourceAsStream("/config/jdbc.properties");//获取输入流
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {//获取properties参数的方法
        return properties;
    }

    public static DBCollection getMongodbConnection() {//获取连接的静态方法
        /**
         * mongo:连接mongodb的服务器
         * db 获取数据库
         *dbCollection 获取y用户库中的集合
         */

        DBCollection dbconnection = (DBCollection) connectionThreadLocal.get();//先从线程绑定集合中获取连接
        Mongo mongo = null;
        String host = properties.getProperty("host");//连接地址
        Integer port = Integer.parseInt(properties.getProperty("port"));//端口号
        String dbName = properties.getProperty("dbName");//数据库名称
        String tableName = properties.getProperty("name");//表名称
        try {
            mongo = new Mongo(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DB db = mongo.getDB(dbName);
        dbconnection = db.getCollection(tableName);

        return dbconnection;
    }

    //将utildate转换为能的插入数据库的sqldate
    public static java.sql.Date UtilDateToSqlSate(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }

    // 将String转换为能插入数据库的sqlDate
    public static java.sql.Date StringToSqlDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 新建数据格式转换对象
        java.util.Date utilDate = null;
        try {
            utilDate = sdf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new java.sql.Date(utilDate.getTime());
    }
}
