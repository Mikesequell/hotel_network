create table role
(
    id   int auto_increment primary key,
    role varchar(64) not null
);

create table hotel
(
    id                    int auto_increment primary key,
    name                  varchar(64)  not null,
    address               varchar(256) not null,
    allQuantityApartments int,
    freeApartments        int,
    occupiedApartments    int
);

create table user
(
    id     int auto_increment primary key,
    roleId int,
    FOREIGN KEY (roleId) REFERENCES role (id)
);

create table login
(
    id       int auto_increment primary key,
    login    varchar(256) not null,
    password varchar(256) not null,
    userId   int          not null,
    foreign key (userId) references user (id)
);

create table user_data
(
    userId          int primary key,
    name            varchar(64) not null,
    surname         varchar(64) not null,
    passport        varchar(64) not null,
    telephoneNumber varchar(64) not null,
    foreign key (userId) references user (id)
);

create table apartment
(
    id              int auto_increment primary key,
    comfortableRank int not null,
    sleepingPlaces  int not null,
    price           int not null,
    userId          int,
    hotelId         int not null,
    foreign key (userId) references user (id),
    foreign key (hotelId) references hotel (id)
);

create table request
(
    id                     int auto_increment primary key,
    comfortableRank        int     not null,
    sleepingPlaces         int     not null,
    arrivalDate            DATE    not null,
    departureDate          DATE    not null,
    offeredPriceForPayment int,
    paymentStatus          boolean not null,
    userId                 int     not null,
    offeredHotelId                int,
    offeredApartmentId            int,
    foreign key (offeredHotelId) references hotel (id),
    foreign key (offeredApartmentId) references apartment (id),
    foreign key (userId) references user (id)
);