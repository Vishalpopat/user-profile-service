drop table if exists user_profile CASCADE;

create table user_profile (
id integer not null,
address varchar(255),
phone_number varchar(15),
user_id integer,
primary key (id)
);

insert into user_profile (id, address, phone_number, user_id) values 
	(1001, 'Bandra, Mumbai', '1111111111', 101),
	(1002, 'Baner, Pune', '2222222222', 102),
	(1003, 'Raiya Road, Rajkot', '3333333333', 103);

