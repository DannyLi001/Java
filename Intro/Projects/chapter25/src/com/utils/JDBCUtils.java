package com.utils;

import com.mysql.cj.protocol.Resultset;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class JDBCUtils {
    private static String user;
    private static String pwd;
    private static String url;
    private static String driver;

    static {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src\\...properties"));
            user = properties.getProperty("user");
            pwd = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            // 将编译异常转成运行异常
            // 调用者可以选择捕获该异常, 也可以选择默认处理异常
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet set, Statement statement, Connection connection){
        try {
            if(set != null){
                set.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
