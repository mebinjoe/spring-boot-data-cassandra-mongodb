package data.cassandra.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.UUID;

public class EmployeeCassandraModel {

    @PrimaryKey
    private UUID id;

    private String firstName;

    private String lastName;

    public EmployeeCassandraModel() {
    }

    public EmployeeCassandraModel(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("EmployeeCassandraModel[id=%s, firstName='%s', lastName='%s']", this.id, this.firstName, this.lastName);
    }

}
