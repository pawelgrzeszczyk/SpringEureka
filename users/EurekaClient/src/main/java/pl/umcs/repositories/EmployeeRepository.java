package pl.umcs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.umcs.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
