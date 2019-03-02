package data.cassandra.repository;

import data.cassandra.entity.EmployeeCassandraModel;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeCassandraRepository extends CrudRepository<EmployeeCassandraModel, String> {

    @Query("Select * from employee where firstname=?0")
    EmployeeCassandraModel findByFirstName(String firstName);

    @Query("Select * from employee where lastname=?0")
    List<EmployeeCassandraModel> findByLastName(String lastName);

}

