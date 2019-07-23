package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationContext<T> {//泛型工厂，用于生成DAO层与Service具体实现类对象
    private static Properties properties = new Properties();

    static {//静态 块加载资源
        try {
            //获取输入流
            InputStream inputStream = ApplicationContext.class.getResourceAsStream("/config/applicationContext.properties");
            //加载资源
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T getBean(String str) {
        Object object = null;
        try {
            Class<?> clazz = Class.forName(properties.getProperty(str));
            object = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) object;
    }
}
