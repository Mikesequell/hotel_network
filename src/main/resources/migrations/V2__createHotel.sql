create table hotel (
                       id int auto_increment primary key,
                       name varchar(64)not null,
                       address varchar(256) not null,
                       allQuantityApartments int,
                       freeApartments int,
                       reservedApartments int,
                       occupiedApartments int
);