use javafx_schema;

create table user(
    id int not null auto_increment primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    username varchar(10),
    password varchar(255)
);

insert into user(first_name, last_name, email, username, password) values('Radulescu','Mihai','mihai@yahoo.com','mihai','mihai');
insert into user(first_name, last_name, email, username, password) values('Popescu','George','george@yahoo.com','george','george');
insert into user(first_name, last_name, email, username, password) values('Popa','Ana','ana@yahoo.com','ana','ana');

select * from user;

alter table user modify username varchar(255) unique;

describe user;