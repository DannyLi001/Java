package com.restaurant.service;

import com.restaurant.dao.EmployeeDao;
import com.restaurant.domain.Employee;

/**
 * @author
 */
public class EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDao();

    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {
        Employee employee =
                employeeDao.querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);
        return employee;
    }
}
