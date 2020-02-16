drop database candy;
create database candy;
use candy;

create table Customer(
    cust_id integer primary key,
    cust_name varchar(30),
    cust_addr varchar(30),
    cust_email varchar(30),
    cust_mobile integer
);

create table Candy(
    candy_id integer primary key,
    candy_name varchar(30),
    candy_type varchar(30),
    candy_stock integer,
    contains_egg integer,
    candy_price integer, 
    candy_weight integer
);

create table Seller(
    seller_id integer primary key,
    seller_name varchar(30),
    seller_addr varchar(30),
    seller_email varchar(30),
    seller_mobile integer
);

create table Purchase(
    purchase_id integer primary key,
    purchase_quantity integer,
    total_bill integer,
    cust_id_purchase integer,
    candy_id_purchase integer,
    constraint cust_candy_fk foreign key (cust_id_purchase) references Customer(cust_id),
    constraint candy_cust_fk foreign key (candy_id_purchase) references Candy(candy_id)
);

create table Candy_Seller(
    id integer primary key,
    add_quantity integer,
    candy_status integer,
    seller_id_fk integer,
    candy_id_fk integer,
    constraint seller_candy_fk foreign key (seller_id_fk)references Seller(seller_id),
    constraint candy_seller_fk foreign key (candy_id_fk) references Candy(candy_id)
);