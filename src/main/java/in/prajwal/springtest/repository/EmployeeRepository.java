package in.prajwal.springtest.repository;

import in.prajwal.springtest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
        List<Employee> findByName(String name);
        //SELECT * FROM table WHERE name="prajwal" AND department = "student"
        List<Employee> findByNameAndDepartment(String name, String department);

//        SELECT * FROM table WHERE name LIKE "%prajwal%"
        List<Employee> findByNameContaining(String keyword);
}
