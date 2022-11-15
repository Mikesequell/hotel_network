create table role
(
    id   int auto_increment primary key,
    role varchar(256) not null
);

create table hotel
(
    id                      int auto_increment primary key,
    name                    varchar(64)  not null,
    address                 varchar(256) not null,
    all_quantity_apartments int,
    free_apartments         int
);

create table user
(
    id      int auto_increment primary key,
    role_id int,
    FOREIGN KEY (role_id) REFERENCES role (id)
);

create table login
(
    id       int auto_increment primary key,
    login    varchar(256) not null,
    password varchar(256) not null,
    user_id  int          not null,
    foreign key (user_id) references user (id)
);

create table user_data
(
    user_id         int primary key,
    name            varchar(64) not null,
    surname         varchar(64) not null,
    passport        varchar(64) not null,
    telephone_number varchar(64) not null,
    foreign key (user_id) references user (id)
);

create table apartment
(
    id               int auto_increment primary key,
    comfortable_rank int not null,
    sleeping_places  int not null,
    price            int not null,
    user_id          int,
    hotel_id         int not null,
    foreign key (user_id) references user (id),
    foreign key (hotel_id) references hotel (id)
);

create table request
(
    id                        int auto_increment primary key,
    comfortable_rank          int     not null,
    sleeping_places           int     not null,
    arrival_date              DATE    not null,
    departure_date            DATE    not null,
    offered_price_for_payment int,
    status                    boolean not null,
    user_id                   int     not null,
    offered_hotel_id          int,
    offered_apartment_id      int,
    foreign key (offered_hotel_id) references hotel (id),
    foreign key (offered_apartment_id) references apartment (id),
    foreign key (user_id) references user (id)
);

INSERT INTO hotel (name, address, all_quantity_apartments) values ('First Hotel', 'ul. Tut 10', '10');

INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (1, 1, 300, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (2, 1, 400, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (3, 2, 800, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (3, 2, 800, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (3, 2, 800, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (4, 2, 800, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (4, 2, 800, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (4, 3, 1000, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (4, 3, 1000, 1);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (5, 3, 1300, 1);


INSERT INTO hotel (name, address, all_quantity_apartments) values ('Second Hotel', 'ul. Tam 2a', '10');

INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (1, 1, 800, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (2, 1, 900, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (3, 2, 1300, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (3, 2, 1300, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (3, 2, 1300, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (4, 2, 1300, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (4, 2, 1300, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (4, 3, 1500, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (4, 3, 1500, 2);
INSERT INTO apartment (comfortable_rank, sleeping_places, price, hotel_id) values (5, 3, 1800, 2);

INSERT INTO role (role) value ('admin');
INSERT INTO role (role) value ('user');

INSERT INTO user (id, role_id) VALUES (1, 1);

INSERT INTO login (login, password, user_id) VALUES ('admin', 'admin', 1);



