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
    free_apartments         int,
    occupied_apartments     int
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