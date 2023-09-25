package com.myjdbc;

/**
 * @author
 */
public class Example {
    public static void main(String[] args) {
        MysqlJDBC mysqlJDBC = new MysqlJDBC();
        mysqlJDBC.getConnection();
        mysqlJDBC.crud();
        mysqlJDBC.close();

        OracleJDBC oracleJDBC = new OracleJDBC();
        oracleJDBC.getConnection();
        oracleJDBC.crud();
        oracleJDBC.close();
    }
}
