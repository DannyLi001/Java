package com.Transaction_;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author
 */
public class Transaction_ {
//    public void test() {
//        for (int i = 0; i < 5000; i++) {
//            ps.setString(1, "jack" + i);
//            ps.setString(2, "123");
//            ps.executeUpdate();
//
//            ps.addBatch();
//            if ((i + 1) % 1000 == 0) {
//                ps.executeBatch();
//                ps.clearBatch();
//            }
//        }
//
//    }

    public static void main(String[] args) {
//        Connection connection = null;
//        PreparedStatement ps = null;
//        try {
//            connection = JDBCUtils.getConnection();
//            connection.setAutoCommit(false);
//            ps = connection.prepareStatement(sql1);
//            ps.executeUpdate();
//
//
//            ps = connection.prepareStatement(spl2);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        } finally {
//            JDBCUtils.close(null, ps, connection);
//        }
    }
}
