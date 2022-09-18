-- set foreign_key_checks = 1;

-- truncate identity;
-- truncate product;
-- truncate register;

select * from identity;
select * from product;
select * from register;

-- describe identity;
-- describe product;
-- describe register;

-- auto_increment
-- not null / unique
-- primary key (`column`)
-- foreign key (`column`) references "table"(`column`)