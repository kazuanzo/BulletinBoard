drop table if exists station cascade;

drop table if exists comment cascade;

drop table if exists board cascade;

drop table if exists board_type cascade;


drop table if exists account cascade;

create table if not exists station(
	id int  not null AUTO_INCREMENT,
	station_name varchar(255) UNIQUE not null,
	PRIMARY KEY (id)
);

create table if not exists account(
	id int  not null AUTO_INCREMENT,
	user_name varchar(128) UNIQUE,
    password varchar(128),
    first_name varchar(128),
    last_name varchar(128),
    role_name varchar(128),
    PRIMARY KEY (id)
);



create table if not exists board(
	id int not null AUTO_INCREMENT,
	board_type_id int not null,
	board_name varchar(255) not null,
	board_content varchar(255) not null,
	create_account_id int null,
	PRIMARY KEY (id)
	
);

create table if not exists board_type(
	id int not null AUTO_INCREMENT,
	board_type varchar(255) not null,
	PRIMARY KEY (id)
	
);
	
create table if not exists comment(
	id int not null AUTO_INCREMENT,
	account_id int not null,
	board_id int not null,

	comment varchar(255) not null,
	PRIMARY KEY (id)
	
);

ALTER TABLE board  add CONSTRAINT FK_aofjqoiefnaifuqpr foreign key (create_account_id) REFERENCES account(id);
ALTER TABLE board add CONSTRAINT FK_aofjqoiefnaifuq foreign key (board_type_id)REFERENCES board_type(id);
ALTER TABLE comment  add CONSTRAINT FK_naufaiuadfafaoi foreign key (board_id)REFERENCES board(id);
ALTER TABLE comment  add CONSTRAINT FK_asdkfjafdfoiaua foreign key (account_id) REFERENCES account(id);

 