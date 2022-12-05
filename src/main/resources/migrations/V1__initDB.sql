create table user
(
    id                      bigint auto_increment primary key,
    username                varchar(255) not null,
    password                varchar(255) not null,
    enabled                 bit(1)       not null,
    credentials_non_expired bit(1)       not null,
    account_non_expired     bit(1)       not null,
    account_non_locked      bit(1)       not null
);

create table role
(
    id   int auto_increment primary key,
    name varchar(255)
);

create table users_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references user (id),
    foreign key (role_id) references role (id)

);

create table status
(
    id   int auto_increment primary key,
    name varchar(256) not null
);

create table hotel
(
    id                      int auto_increment primary key,
    name                    varchar(64)  not null,
    address                 varchar(256) not null,
    all_quantity_apartments bigint
);

create table user_data
(
    user_id          bigint primary key,
    name             varchar(64) not null,
    surname          varchar(64) not null,
    passport         varchar(64) not null,
    telephone_number varchar(64) not null,
    foreign key (user_id) references user (id)
);

create table apartment
(
    id               bigint auto_increment primary key,
    comfortable_rank int not null,
    sleeping_places  int not null,
    price            int,
    status_id        int,
    hotel_id         int not null,
    foreign key (status_id) references status (id),
    foreign key (hotel_id) references hotel (id)
);

create table request
(
    id                        bigint auto_increment primary key,
    arrival_date              DATE   not null,
    departure_date            DATE   not null,
    offered_price_for_payment int,
    status_id                 int,
    user_id                   bigint not null,
    apartment_id              bigint,
    foreign key (status_id) references status (id),
    foreign key (apartment_id) references apartment (id),
    foreign key (user_id) references user (id)
);

INSERT INTO status (name) value ('created');
INSERT INTO status (name) value ('in processing');
INSERT INTO status (name) value ('response awaiting');
INSERT INTO status (name) value ('awaiting payment');
INSERT INTO status (name) value ('paid');
INSERT INTO status (name) value ('cancelled');
INSERT INTO status (name) value ('completed');
INSERT INTO status (name) value ('free');
INSERT INTO status (name) value ('occupied');

INSERT INTO hotel (name, address, all_quantity_apartments)
values ('First Hotel', 'ul. Tut 10', '10');

INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (1, 1, 300, 8, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (2, 1, 400, 8, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (3, 2, 800, 8, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (3, 2, 800, 8, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (3, 2, 800, 8, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (4, 2, 800, 8, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (4, 2, 800, 8, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (4, 3, 1000, 8, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (4, 3, 1000, 8, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (5, 3, 1300, 8, 1);


INSERT INTO hotel (name, address, all_quantity_apartments)
values ('Second Hotel', 'ul. Tam 2a', '10');

INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (1, 1, 800, 8, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (2, 1, 900, 8, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (3, 2, 1300, 8, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (3, 2, 1300, 8, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (3, 2, 1300, 8, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (4, 2, 1300, 8, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (4, 2, 1300, 8, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (4, 3, 1500, 8, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (4, 3, 1500, 8, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, status_id, hotel_id)
values (5, 3, 1800, 8, 2);


INSERT INTO user (username, password, enabled, credentials_non_expired, account_non_expired, account_non_locked)
VALUES ('admin', '$2a$12$TK3q.SPndYjzZRZ8ZEEh5.iggVGIqA2./JW.zwuKUYWi8XTZfic4S', 1, 1, 1, 1);

INSERT INTO user (username, password, enabled, credentials_non_expired, account_non_expired, account_non_locked)
VALUES ('user', '$2a$12$gjrRSj/jQukJi/NMhwSXzOdOEk/90eMc/ITHBmiKCBlnuNm9xJlqS', 1, 1, 1, 1);

INSERT INTO role(name) value ('ROLE_ADMIN');
INSERT INTO role(name) value ('ROLE_USER');


INSERT INTO users_roles (user_id, role_id)
VALUES ('1', '1');
INSERT INTO users_roles (user_id, role_id)
VALUES ('1', '2');
INSERT INTO users_roles (user_id, role_id)
VALUES ('2', '2');
