
CREATE SEQUENCE seq_user
START WITH 100;

create table "user" (
	id int not null default nextval('seq_user'),
	name varchar(255),
	primary key(id)
);

CREATE SEQUENCE seq_application
START WITH 100;

create table application (
	id int not null default nextval('seq_application'),
	name varchar(255),
	primary key(id)
);

CREATE SEQUENCE seq_invitation
START WITH 100;

create table invitation (
	id int not null default nextval('seq_invitation'),
	phone varchar(32) UNIQUE,
	author int references "user" (id),
	application int references application (id),
	createdon timestamp not null default CURRENT_TIMESTAMP,
	primary key(id)
);

