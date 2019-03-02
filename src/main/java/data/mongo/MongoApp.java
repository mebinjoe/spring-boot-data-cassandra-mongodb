package data.mongo;

import data.mongo.entity.Employee;
import data.mongo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApp implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        //clear the state
        this.employeeRepository.deleteAll();

        // add some employees
        this.employeeRepository.save(new Employee("John", "Honai"));
        this.employeeRepository.save(new Employee("Dada", "Saheeb"));
        this.employeeRepository.save(new Employee("Sam", "Alex"));

        // fetch all employees
        System.out.println("Employees found with findAll():");
        System.out.println("-------------------------------");
        for (Employee employee : this.employeeRepository.findAll()) {
            System.out.println(employee);
        }
        System.out.println();

        // fetch an individual employee
        System.out.println("Employee found with findByFirstName('Sam'):");
        System.out.println("--------------------------------");
        System.out.println(this.employeeRepository.findByFirstName("Sam"));

        System.out.println("Employee found with findByLastName('Honai'):");
        System.out.println("--------------------------------");
        for (Employee employee : this.employeeRepository.findByLastName("Honai")) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoApp.class, args);
    }

}
