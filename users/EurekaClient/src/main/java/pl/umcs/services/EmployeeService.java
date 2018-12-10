package pl.umcs.services;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umcs.model.Employee;
import pl.umcs.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee save(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    public Employee find(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    public List<Employee> findAll() {
        Iterable<Employee> employeesIterable = employeeRepository.findAll();
        List<Employee> employeesList = Lists.newArrayList(employeesIterable);
        return employeesList;
    }

    public Employee update(Employee employee) {
        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public String takeHolidays(Long id, int days){
        Optional<Employee> employee = employeeRepository.findById(id);
        int daysleft = 0;
        if (employee.isPresent()) {
            Employee e = employee.get();
            e.setNumberOfDays(e.getNumberOfDays()- days);
            daysleft = e.getNumberOfDays();
            employeeRepository.save(e);
        }
        return "Employee "+id+" have taken "+days+" days off, he still has "+daysleft+" free days";

    }
}
