drop table authorities;
drop table users;
create table users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);
create table authorities (
	username varchar(50) not null references users (username),
	authority varchar(50) not null
);
