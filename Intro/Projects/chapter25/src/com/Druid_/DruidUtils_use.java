package com.Druid_;

import com.mysql.cj.jdbc.Driver;
import com.utils.JDBCUtils;
import com.utils.JDBCUtilsByDruid;

import java.sql.*;
import java.util.Properties;

/**
 * @author
 */
public class DruidUtils_use {
    public static void main(String[] args) {
        Connection connect = null;

        // 执行sql
        String sql = "select * from t1";
        // statement用于执行静态sql语句并返回其生成的结果对象
        PreparedStatement preparedStatement = null;
        ResultSet set = null;

        try {
            connect = JDBCUtilsByDruid.getConnection();
            preparedStatement = connect.prepareStatement(sql);
            set = preparedStatement.executeQuery();
            while (set.next()) {
                int num = set.getInt(1);
                String name = set.getString(2);
                System.out.println("num " + num + " name " + name);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtilsByDruid.close(set,preparedStatement,connect);

    }
}
