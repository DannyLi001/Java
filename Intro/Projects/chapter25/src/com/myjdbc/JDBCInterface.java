package com.myjdbc;

/**
 * @author
 */
public interface JDBCInterface {
    public Object getConnection();
    public void crud();
    public void close();
}
