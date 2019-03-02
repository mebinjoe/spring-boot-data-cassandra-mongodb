CREATE KEYSPACE appkeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
CREATE TABLE employee (id TimeUUID PRIMARY KEY, firstname text, lastname text);
CREATE INDEX employeefistnameindex ON employee (firstname);
CREATE INDEX employeesecondnameindex ON employee (lastname);