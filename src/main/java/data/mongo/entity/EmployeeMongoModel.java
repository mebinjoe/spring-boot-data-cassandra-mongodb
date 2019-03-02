package data.mongo.entity;

import org.springframework.data.annotation.Id;

public class EmployeeMongoModel {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    public EmployeeMongoModel() {
    }

    public EmployeeMongoModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Employee[id=%s, firstName='%s', lastName='%s']", this.id, this.firstName, this.lastName);
    }

}
