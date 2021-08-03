package pl.piotr.skBackdend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotr.skBackdend.entity.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Long >{
}
