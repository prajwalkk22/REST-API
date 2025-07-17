package in.prajwal.springtest.controller;
import in.prajwal.springtest.model.Employee;
import in.prajwal.springtest.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

//@Controller
@RestController //@Controller + @ResponseBody
//this class is responsible for handling http requests and the server will send all the http requests to these classes


//localhost:8080/api/v1/employees
public class EmployeeController {

    @Autowired
    private EmployeeService eService;
  //getting value from application.properties
   // @Value("${app.name:Employee Tracker}")
    //private String appName;

   // @Value("${app.name:version1}")
   // private String appVersion;

   // @GetMapping("/version")
    //public String getAppDetails(){
    //   return appName+" - "+appVersion;
    //}
    //localhost:8000/employees

//    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<List<Employee>>(eService.getEmployees(), HttpStatus.OK);
    }
    //localhost:8080/employees/12
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
       return eService.getSingleEmployee(id);
    }

    //localhost:8080/emploees?id=34
    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam("id") long id){
        eService.deleteEmployee(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(eService.saveEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        employee.setId(id);
        return eService.updateEmployee(employee);
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name),HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndDepartment")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name,@RequestParam String department){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndDepartment(name,department),HttpStatus.OK);
    }

    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name),HttpStatus.OK);
    }




}
