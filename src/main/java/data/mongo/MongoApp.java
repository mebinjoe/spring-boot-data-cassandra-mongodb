package data.mongo;

import data.cassandra.CassandraApp;
import data.mongo.entity.EmployeeMongoModel;
import data.mongo.repository.EmployeeMongoRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApp implements CommandLineRunner {

    private static final Log logger = LogFactory.getLog(MongoApp.class);

    @Autowired
    private EmployeeMongoRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        //clear the state
        this.employeeRepository.deleteAll();

        // add some employees
        this.employeeRepository.save(new EmployeeMongoModel("John", "Honai"));
        this.employeeRepository.save(new EmployeeMongoModel("Dada", "Saheeb"));
        this.employeeRepository.save(new EmployeeMongoModel("Sam", "Alex"));

        // fetch all employees
        logger.info("Employees found with findAll():");
        logger.info("-------------------------------");
        for (EmployeeMongoModel employee : this.employeeRepository.findAll()) {
            logger.info(employee);
        }
        System.out.println();

        // fetch an individual employee
        logger.info("Employee found with findByFirstName('Sam'):");
        logger.info("--------------------------------");
        logger.info(this.employeeRepository.findByFirstName("Sam"));

        logger.info("Employee found with findByLastName('Honai'):");
        logger.info("--------------------------------");
        for (EmployeeMongoModel employee : this.employeeRepository.findByLastName("Honai")) {
            logger.info(employee);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoApp.class, args);
    }

}
