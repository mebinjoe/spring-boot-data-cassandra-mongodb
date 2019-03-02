package data.mongo.repository;

import data.mongo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

}

