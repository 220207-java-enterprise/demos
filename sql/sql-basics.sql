-- Single line comments

/*
   Multi
   line
   comments
*/

/*
	Demo Schema:
	
		- Departments
			+ id (primary key)
			+ name
			+ monthly_budget
			
		- Employees
			+ id (primary key)
			+ first_name
			+ last_name
			+ birthdate
			+ monthly_income
			+ department_id (foreign key)
			+ hire_date
			+ job_title
			+ email
			
		- Products
			+ id (primary key)
			+ name
			+ price
			+ expiration_date
			
*/

-- Common to see a series of DROP table statements at the beginning of any table creation script
drop table if exists products;
drop table if exists employees;
drop table if exists departments;

create table departments (
	id serial constraint department_pk primary key, -- inline constraint declaration
	name varchar(25) unique not null, -- candidate key (a column that COULD be a primary key)
	monthly_budget numeric(8, 2) -- first # is precision (# of digits), second # is scale (# of decimal places)
	-- 999999.99
);

-- 
insert into departments values (1, 'Accounting', 20000.00);
insert into departments (name, monthly_budget) values ('Marketing', 15000.00);
insert into departments (name, monthly_budget)
values
    ('IT', 30000),
    ('Human Resources', 25000),
    ('Customer Service', 2000),
    ('Regulatory Affairs', 5000);

select * from departments;

create table employees (
	id				serial,
	first_name		varchar(25) not null,
	last_name		varchar(25) not null,
	birthdate		date not null,
	monthly_income	numeric (7, 2),
	department_id	int,
	hire_date		date default current_date,
	job_title		varchar(25) not null,
	email			varchar(320) not null,
	
	-- another way of declaring constraints
	constraint employees_pk 
	primary key (id),
	
	constraint employee_department_fk
	foreign key (department_id)
	references departments 
	
	-- by default, FKs automatically point to the PK of the referenced table
	-- FKs can point to non-PK columns in a referenced table, so long as the referenced column is UNIQUE
	
);

create table products(
	id				serial, 
	name			varchar(50) not null,
	price			numeric(7, 2) default 0,
	expiration_date	date not null
);

alter table products 
add constraint products_pk primary key (id);

-- No need to COMMIT any DDL statements, they are implicitly commited after execution

select * from departments;
delete from departments; -- DML statements (INSERT, UPDATE, DELETE) require explicit commit statements to be "saved"
truncate table departments;
rollback; -- undoes the uncommitted work (up to the most recent commit/savepoint)

insert into employees (first_name, last_name, birthdate, monthly_income, department_id, hire_date, job_title, email) 
values 
	('JOHN', 'SMITH', date '1995-01-01', 4000.00, 1, date '2015-03-28', 'AC_ACCOUNT', 'JSMITH'), 
	('JAMES', 'BOSH', date '1992-02-15', 3500.00, 2, date '2014-07-01', 'MK_REP', 'JBOSH'),
	('LUISA', 'JACKSON', date '1970-03-08', 4500.00, 3, date '2013-08-29', 'IT_PROG', 'LJACKSON'),
	('STUART', 'GARCIA', date '1965-04-12', 2000.00, 4, date '2010-02-15', 'HR_REP', 'SGARCIA'),
	('JUSTIN', 'BLACK', date '1990-05-16', 2550.00, 1, date '2015-05-02', 'AC_ACCOUNT', 'JBLACK'),
	('ANGIE', 'CROOD', date '1998-06-22', 1500.00, 1, date '2015-07-01', 'AC_ACCOUNT', 'ACROOD'),
	('CHARLES', 'DEAN', date '1973-06-08', 2250.00, 3, date '2002-03-01', 'IT_PROG', 'CDEAN'),
	('EDDIE', 'FARREL', date '1980-07-28', 3000.00, 1, date '2009-04-20', 'AC_ACCOUNT', 'EFARREL'),
	('GEORGE', 'HAYES', date '1982-08-03', 2500.00, 2, date '2012-09-22', 'MK_REP', 'GHAYES'),
	('IGOR', 'OSBOURNE', date '1987-09-11', 6000.00, 3, date '2014-11-14', 'IT_PROG', 'IKEYS'),
	('LUKE', 'MINT', date '1985-10-19', 5000.00, 4, date '2011-01-08', 'HR_REP', 'LMINT'),
	('NIGEL', 'OAKS', date '1997-11-05', 4750.00, 4, date '2014-10-01', 'HR_REP', 'NOAKS'),
	('LUKE', 'GREEN', date '1995-02-05', 4750.00, 4, date '2015-09-01', 'HR_REP', 'LGREEN');

select * from employees;
insert into employees (first_name, last_name, birthdate, monthly_income, department_id, job_title, email)
values ('WEZLEY', 'SINGLETON', date '1990-07-09', 5000, 3, 'DEV', 'WSINGLETON');

insert into products (name, price, expiration_date) 
values 
	('Aspirin', 5.00, date '2020-12-31'),
	('Penicillin', 10.00, date '2019-04-30'),
	('Insulin', 25.00, date '2018-05-31'),
	('Acetaminophen', 5.00, date '2019-01-31'),
	('Amoxicillin', 8.00, date '2018-07-31');
	
select * from products;








