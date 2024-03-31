import Employee.Employee;

public class FilterEmployeebyAge implements MyPredict<Employee> {

    @Override
    public boolean test(Employee t) {
        return t.getAge() >= 35;
        
    }
    
}
