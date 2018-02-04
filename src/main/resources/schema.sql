drop table if exists account cascade;

drop table if exists comment cascade;

drop table if exists board cascade;

drop table if exists user cascade;

drop table if exists account cascade;


create table if not exists account(
	id int  not null AUTO_INCREMENT,
	user_name varchar(128),
    password varchar(128),
    first_name varchar(128),
    last_name varchar(128),
    role_name varchar(128),
    PRIMARY KEY (id)
);

create table if not exists user(
	id int  not null AUTO_INCREMENT,
	user_name varchar(255) not null,
	password varchar(255) not null,
	old int not null,
	PRIMARY KEY (id)
);

create table if not exists board(
	id int not null AUTO_INCREMENT,
	board_name varchar(255) not null,
	user_id int null,
	PRIMARY KEY (id)
	
);

create table if not exists comment(
	id int not null AUTO_INCREMENT,
	user_id int not null,
	board_id int not null,

	comment varchar(255) not null,
	PRIMARY KEY (id)
	
);
ALTER TABLE board  add CONSTRAINT FK_aofjqoiefnaifuqpr foreign key (user_id)
 REFERENCES user(id);
 ALTER TABLE comment  add CONSTRAINT FK_asdkfjafdfoiaua foreign key (user_id)
 REFERENCES user(id);
 ALTER TABLE comment  add CONSTRAINT FK_naufaiuadfafaoi foreign key (board_id)
 REFERENCES board(id);
 