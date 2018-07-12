insert into users(username,password,enabled)
	values('admin','$2a$10$8lazwgVPyhbMHcpW0W5wzumqPmbsZtRMydoeYsIPxZw0No6OmvTle',true);
insert into authorities(username,authority) 
	values('admin','ROLE_ADMIN');
	