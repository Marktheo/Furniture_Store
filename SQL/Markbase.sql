-- Creating Database named Mark
create database if not exists markbase;

-- Creating Tables from Mark
-- Identity
create table if not exists identity(
id int(10) auto_increment not null,
fName varchar(20) not null,
lName varchar(20) not null,
bDate date not null,
sex char(1) not null,
cpf varchar(14) not null unique,
primary key (`id`));

-- Register
create table if not exists register(
idReg int(10) auto_increment not null,
email varchar(40) not null unique,
keyword varchar(40) not null,
regDate date not null,
primary key (`idReg`));

-- Product
create table if not exists product(
idProd int(10) auto_increment not null,
pName varchar(40) not null,
material varchar(40) not null,
primary key (`idProd`));

INSERT INTO product (pName, material) values ('Chair', 'Wood');
INSERT INTO product (pName, material) values ('Table', 'Wood');
INSERT INTO product (pName, material) values ('Bench', 'Wood');
INSERT INTO product (pName, material) values ('Chandeliers', 'Aluminum');
INSERT INTO product (pName, material) values ('Sofa', 'Wood');
INSERT INTO product (pName, material) values ('Cabinet', 'Wood');