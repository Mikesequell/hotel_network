create table login
(
    id         int auto_increment primary key,
    login      varchar(256) not null,
    password   varchar(256) not null,
    customerId int          not null,
    foreign key (customerId) references customer (id)
);