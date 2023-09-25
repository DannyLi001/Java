package com.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        // 前置工作：在项目下创建文件夹libs
        // 将 .jar 文件加入到项目中
        Driver driver = new Driver();

        // jdbc:mysql:// 规定好的协议, 通过jdbc方式连接mysql
        // localhost:3306 ip地址及监听端口
        // db1 操作的数据库
        // mysql连接本质就是socket连接
        String url = "jdbc:mysql://localhost:3306/db1";

        // 用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root"); // 用户
        properties.setProperty("password","123");   // 密码
        // 获得连接
        Connection connect = driver.connect(url, properties);

        // 执行sql
        String sql = "update t1 set name = 'nick' where num = 1";
        // statement用于执行静态sql语句并返回其生成的结果对象
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);

        // 关闭连接
        System.out.println(i > 0 ? "success" : "fail");
        statement.close();
        connect.close();
    }
}
