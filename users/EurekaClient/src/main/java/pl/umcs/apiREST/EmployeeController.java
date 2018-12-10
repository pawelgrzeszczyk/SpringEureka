package pl.umcs.apiREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.umcs.model.Employee;
import pl.umcs.services.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@Component
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private final EmployeeService employeeService;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Employee> getEployee() {
        List<Employee> employees = employeeService.findAll();
        log.info("Retrieve objects {}", employees);
        return employees;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Employee save(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.save(employee);
        log.info("Add employee {}", savedEmployee);
        return savedEmployee;
    }

    @GetMapping("/{id}")
    public Employee find(@PathVariable Long id) {
        return employeeService.find(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        log.info("Delete employee with id {}", id);
        return new ResponseEntity(NO_CONTENT);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Employee update(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.update(employee);
        log.info("Updated Employee {}", updatedEmployee);
        return updatedEmployee;
    }


}
