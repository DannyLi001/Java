package com.PreparedStatement_;

import java.sql.*;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class PreparedStatement_{
    public static void main(String[] args) throws Exception{


        String user = "root";
        String pwd = "123";
        String url = "jdbc:mysql://localhost:3306/db1";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, pwd);

        String sql = "select num, name from t1 where num=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"1");
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
        }
    }
}
