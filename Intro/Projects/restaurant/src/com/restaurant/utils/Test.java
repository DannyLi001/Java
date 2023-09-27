package com.restaurant.utils;

import java.sql.Connection;

/**
 * @author
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
    }
}
