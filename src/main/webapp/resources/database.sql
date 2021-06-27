create table users
(
    id       serial primary key,
    username varchar(50)  not null,
    password varchar(255) not null);

CREATE TABLE roles
(
    id   serial PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

create table user_roles
(
    user_id int not null,
    role_id int not null,

    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into users values (1, 'madyar', '1234');

insert into roles values (1, 'ROLE_USER');
insert into roles values (2, 'ROLE_ADMIN');

insert into user_roles values (1, 2);
