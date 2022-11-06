create table request
(
    id                     int auto_increment primary key,
    comfortableRank        int         not null,
    sleepingPlaces         int         not null,
    arrivalDate            varchar(32) not null,
    departureDate          varchar(32) not null,
    offeredPriceForPayment int,
    paymentStatus          boolean     not null
);