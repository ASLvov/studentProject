DROP TABLE IF EXISTS jc_passport_office;
DROP TABLE IF EXISTS jc_register_office;
DROP TABLE IF EXISTS jc_country_struct;
DROP TABLE IF EXISTS jc_street;

CREATE TABLE jc_street (
	street_code integer not null,
	street_name varchar(300),
	PRIMARY KEY (street_code)
);

CREATE TABLE jc_country_struct (
	area_id char(12) not null,
	area_name varchar(200),
	PRIMARY KEY (area_id)
);

CREATE TABLE jc_passport_office (
	ps_office_id integer not null,
	ps_office_area_id char(12) not null,
	ps_office_name varchar(200),
	PRIMARY KEY (ps_office_id),
	FOREIGN KEY (ps_office_area_id)
		REFERENCES jc_country_struct(area_id) ON DELETE RESTRICT
);

CREATE TABLE jc_register_office (
	reg_office_id integer not null,
	reg_office_area_id char(12) not null,
	reg_office_name varchar(200),
	PRIMARY KEY (reg_office_id),
	FOREIGN KEY (reg_office_area_id)
		REFERENCES jc_country_struct(area_id) ON DELETE RESTRICT
)