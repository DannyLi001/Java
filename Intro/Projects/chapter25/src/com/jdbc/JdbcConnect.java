package com.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author
 */
public class JdbcConnect {
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db1";

        // 用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root"); // 用户
        properties.setProperty("password", "123");   // 密码
        // 获得连接
        Connection connect = driver.connect(url, properties);
    }

    @Test
    public void connection2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)aClass.getConstructor().newInstance();
        String url = "jdbc:mysql://localhost:3306/db1";

        // 用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root"); // 用户
        properties.setProperty("password", "123");   // 密码
        // 获得连接
        Connection connect = driver.connect(url, properties);
    }

    @Test
    public void connection3() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)aClass.getConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/db1";
        String user = "root";
        String pwd = "123";

        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, pwd);
    }

    // 推荐
    @Test
    public void connection4() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 底层代码块实现 DriverManager.registerDriver(driver);

        String url = "jdbc:mysql://localhost:3306/db1";
        String user = "root";
        String pwd = "123";
        Connection connection = DriverManager.getConnection(url, user, pwd);

    }

    @Test
    public void connection5() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\...properties"));
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, pwd);
    }
}
