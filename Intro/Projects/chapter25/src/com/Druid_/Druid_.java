package com.Druid_;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author
 */
public class Druid_ {
    // 加入druid jar包
    // 加入 配置文件
    // 创建Properties对象, 读取配置文件
    public void test1() throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        // 创建一个指定参数的数据库连接池, druid连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        for (int i = 0; i < 5000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }

    }
}
