create table customer
(
    id        int auto_increment primary key,
    passport  varchar(64) not null,
    statusId  int,
    FOREIGN KEY (statusId) REFERENCES customer_status (id)
);