create table apartment
(
    id              int auto_increment primary key,
    comfortableRank int not null,
    sleepingPlaces  int not null,
    price           int not null,
    customerId      int,
    hotelId         int,
    foreign key (customerId) references customer (id),
    foreign key (hotelId) references hotel (id)
);