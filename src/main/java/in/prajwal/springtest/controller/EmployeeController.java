package in.prajwal.springtest.controller;
import in.prajwal.springtest.model.Employee;
import in.prajwal.springtest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Employee> getEmployees(){
        return eService.getEmployees();
    }
    //localhost:8080/employees/12
    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable("id") Long id){
        return "Fetching the employee details for the id " + id;
    }

    //localhost:8080/emploees?id=34
    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam("id") long id){
        return "Deleting the employee id " + id;
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){
            return "saving the employee details to the database " + employee;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        return employee;
    }
}
