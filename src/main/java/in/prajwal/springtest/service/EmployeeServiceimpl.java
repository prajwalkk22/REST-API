package in.prajwal.springtest.service;

import in.prajwal.springtest.model.Employee;
import in.prajwal.springtest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return eRepository.findAll(pageable).getContent();
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

    @Override
    public List<Employee> getEmployeesByName(String name){
        return eRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndDepartment(String name,String department){
        return eRepository.findByNameAndDepartment(name,department);
    }

    @Override
     public  List<Employee> getEmployeesByKeyword(String name){
        return eRepository.findByNameContaining(name);
    }

}

