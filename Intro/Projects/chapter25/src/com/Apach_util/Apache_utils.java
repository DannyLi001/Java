package com.Apach_util;

import com.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author
 */
public class Apache_utils {
    @Test
    public void test() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 使用DBUtils类和端口, 引入DBUtils jar包
        QueryRunner queryRunner = new QueryRunner();

        // query 方法就是执行sql语句, 得到resultset ---封装--> ArrayList中
        // 返回集合
        // connection: 连接
        // new BeanListHandler<>(Actor.class): 将resultset -> actor对象 -> 封装到arraylist
        // 底层使用反射机制, 去获取actor类的属性, 然后进行封装
        // t1: 给sql语句?赋值, 可以有多个值 因为是可变参数
        // 底层获得到的resultset会在query中关闭
        List<Actor> query = queryRunner.query(connection, "select name from t1 where num = ?", new BeanListHandler<>(Actor.class), 1);

        for (Actor actor : query) {
            System.out.println(actor);
        }
        JDBCUtilsByDruid.close(null, null, connection);

    }

    @Test
    public void test2() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String sql = "select * from t1 where num = ?";
        Actor query = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 3);
        System.out.println(query);
        connection.close();
    }

    @Test
    public void test3() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String sql = "select `name` from t1 where num = ?";
        Object query = queryRunner.query(connection, sql, new ScalarHandler(), 3);
        System.out.println(query);

        connection.close();
    }

    @Test
    public void test4() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String sql = "update t1 set name = ? where num = ?";
        int i = queryRunner.update(connection, sql, "name1", 2);
        System.out.println(i);
        connection.close();
    }
}

