package data.cassandra;

import com.datastax.driver.core.utils.UUIDs;
import data.cassandra.entity.EmployeeCassandraModel;
import data.cassandra.repository.EmployeeCassandraRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CassandraApp implements CommandLineRunner {

    private static final Log logger = LogFactory.getLog(CassandraApp.class);

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
        logger.info("Employees found with findAll():");
        logger.info("-------------------------------");
        for (EmployeeCassandraModel employee : this.employeeRepository.findAll()) {
            logger.info(employee);
        }
        System.out.println();

        // fetch an individual employee
        logger.info("Employee found with findByFirstName('Dada'):");
        logger.info("--------------------------------");
        logger.info(this.employeeRepository.findByFirstName("Dada"));

        logger.info("Employee found with findByLastName('Honai'):");
        logger.info("--------------------------------");
        for (EmployeeCassandraModel employee : this.employeeRepository.findByLastName("Honai")) {
            logger.info(employee);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CassandraApp.class, args);
    }

}
