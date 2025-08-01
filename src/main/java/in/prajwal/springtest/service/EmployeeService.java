package in.prajwal.springtest.service;

import in.prajwal.springtest.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees(int pageNumber, int pageSize, String sortField, String sortDirection);


    Employee saveEmployee(Employee employee);

    Employee getSingleEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByNameAndDepartment(String name,String department);

    List<Employee> getEmployeesByKeyword(String keyword);

}
