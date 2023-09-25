package com.resultset;


import java.sql.*;

/**
 * @author
 */
public class ResultSet_ {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        String user = "root";
        String pwd = "123";
        String url = "jdbc:mysql://localhost:3306/db1";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, pwd);

        Statement statement = connection.createStatement();

        String sql = "select * from t1";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            System.out.printf("num " + anInt + " name " + string);
            System.out.println();
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
