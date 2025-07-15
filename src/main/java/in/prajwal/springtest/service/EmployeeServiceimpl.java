package in.prajwal.springtest.service;

import in.prajwal.springtest.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    private static  List<Employee> list = new ArrayList<>();

    static {
        Employee e = new Employee();
        e.setName("prajwal");
        e.setAge(28L);
        e.setDepartment("IT");
        e.setEmail("prajwal12@gmail.com");
        e.setLocation("India");

        list.add(e);
    }
    static {
        Employee e = new Employee();
        e.setName("prajwalkk");
        e.setAge(19L);
        e.setDepartment("IT");
        e.setEmail("prajwal12@gmail.com");
        e.setLocation("India");

        list.add(e);
    }

    @Override
    public List<Employee> getEmployees() {
        return list;
    }
}

