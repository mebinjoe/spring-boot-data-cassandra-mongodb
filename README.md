# spring-boot-data-cassandra-mongodb

Prototype model for incooperating two datasources i.e; `Cassandra` and `MongoDB` in a single micro-service as a spring boot application.

### Prerequisites

Good to have a basic knowledge of:

```
MongoDB, Cassandra, Java8 or above
```

### Clone

- Clone this repo to your local machine using `https://github.com/mebinjoe/spring-boot-data-cassandra-mongodb.git`

### Configuration

Specify below config parameters accordingly:

```
#MongoDB config
spring.data.mongodb.authentication-database=
spring.data.mongodb.port=27017
spring.data.mongodb.host=

#Cassandra config
spring.data.cassandra.keyspace-name=
```

### Running

```
$ mvn spring-boot:run
```