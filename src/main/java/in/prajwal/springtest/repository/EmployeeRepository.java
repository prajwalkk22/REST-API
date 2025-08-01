package in.prajwal.springtest.repository;

import in.prajwal.springtest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

        List<Employee> findByName(String name);

        List<Employee> findByNameAndDepartment(String name, String department);

        List<Employee> findByNameContaining(String keyword);
}
