package data.mongo.repository;

import data.mongo.entity.EmployeeMongoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeMongoRepository extends MongoRepository<EmployeeMongoModel, String> {

    EmployeeMongoModel findByFirstName(String firstName);

    List<EmployeeMongoModel> findByLastName(String lastName);

}

