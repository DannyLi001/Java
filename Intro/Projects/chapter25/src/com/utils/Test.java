package com.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author
 */
public class Test {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }
}
