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
    public Employee getEmployee(@PathVariable("id") Long id){
       return eService.getSingleEmployee(id);
    }

    //localhost:8080/emploees?id=34
    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam("id") long id){
        eService.deleteEmployee(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return eService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        employee.setId(id);
        return eService.updateEmployee(employee);
    }
}
