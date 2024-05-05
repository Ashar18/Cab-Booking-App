use cab;
create table customer(
	cust_id int primary key AUTO_INCREMENT,
	cust_name varchar(50) not null,
	username varchar(50) unique not null,
	password varchar(50) unique not null,
	c_phone varchar(50) unique not null,
	address varchar(50) not null,
	account_no varchar(50) not null,
	pickup_location varchar(50),
	dest_location  varchar(50),
	select_vehicle  varchar(50)
);

create table rider(
	rider_id int primary key AUTO_INCREMENT,
	rider_name varchar(50) not null,
	username varchar(50) unique not null,
	password varchar(50) unique not null,
	r_phone varchar(50) unique not null,
	location varchar(50),
	vehicle  varchar(50) not null
);

create table ride_book(
	rider_id int,
    cust_id int,
	
    FOREIGN KEY (rider_id) REFERENCES rider(rider_id),
    FOREIGN KEY (cust_id) REFERENCES customer(cust_id)
);

create table history(
	rider_id int,
    cust_id int,
    time varchar(50) not null,
	
    FOREIGN KEY (rider_id) REFERENCES rider(rider_id),
    FOREIGN KEY (cust_id) REFERENCES customer(cust_id)
);

ALTER TABLE `cab`.`ride_book` 
ADD COLUMN `status` VARCHAR(10) NULL AFTER `id`;
