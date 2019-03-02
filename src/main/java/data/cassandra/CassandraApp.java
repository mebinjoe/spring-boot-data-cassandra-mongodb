package data.cassandra;

import com.datastax.driver.core.utils.UUIDs;
import data.cassandra.entity.EmployeeCassandraModel;
import data.cassandra.repository.EmployeeCassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CassandraApp implements CommandLineRunner {

    @Autowired
    private EmployeeCassandraRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        //clear the state
        this.employeeRepository.deleteAll();

        // add some employees
        this.employeeRepository.save(new EmployeeCassandraModel(UUIDs.timeBased(), "John", "Honai"));
        this.employeeRepository.save(new EmployeeCassandraModel(UUIDs.timeBased(), "Dada", "Saheeb"));
        this.employeeRepository.save(new EmployeeCassandraModel(UUIDs.timeBased(), "Sam", "Alex"));

        // fetch all employees
        System.out.println("Employees found with findAll():");
        System.out.println("-------------------------------");
        for (EmployeeCassandraModel employee : this.employeeRepository.findAll()) {
            System.out.println(employee);
        }
        System.out.println();

        // fetch an individual employee
        System.out.println("Employee found with findByFirstName('Dada'):");
        System.out.println("--------------------------------");
        System.out.println(this.employeeRepository.findByFirstName("Dada"));

        System.out.println("Employee found with findByLastName('Honai'):");
        System.out.println("--------------------------------");
        for (EmployeeCassandraModel employee : this.employeeRepository.findByLastName("Honai")) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CassandraApp.class, args);
    }

}
