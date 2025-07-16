package in.prajwal.springtest.service;

import in.prajwal.springtest.model.Employee;
import in.prajwal.springtest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees() {
       return eRepository.findAll();
    }
    @Override
    public Employee saveEmployee(Employee employee){
      return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id){
        Optional<Employee> employee = eRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Employee is not found for the id " + id);
    }

    @Override
    public void deleteEmployee(Long id){
        eRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee){
        return eRepository.save(employee);
    }
}

