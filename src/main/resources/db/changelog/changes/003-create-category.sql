drop table if exists category;

create table category (
                id SERIAL PRIMARY KEY,
                description varchar(50),
                created_date timestamp,
                last_modified_date timestamp
);

drop table if exists product_category;

create table product_category (
                product_id INT REFERENCES product(id) ON UPDATE CASCADE ON DELETE CASCADE,
                category_id INT REFERENCES category(id) ON UPDATE CASCADE,
                constraint product_category_pkey PRIMARY KEY (product_id, category_id)
);

insert into product (description, product_status, created_date, last_modified_date)
values ('PRODUCT1', 'NEW', now(), now());

insert into product (description, product_status, created_date, last_modified_date)
values ('PRODUCT2', 'NEW', now(), now());

insert into product (description, product_status, created_date, last_modified_date)
values ('PRODUCT3', 'NEW', now(), now());

insert into product (description, product_status, created_date, last_modified_date)
values ('PRODUCT4', 'NEW', now(), now());

insert into category (description, created_date, last_modified_date) VALUES
    ('CAT1', now(), now());

insert into category (description, created_date, last_modified_date) VALUES
    ('CAT2', now(), now());

insert into category (description, created_date, last_modified_date) VALUES
    ('CAT3', now(), now());

insert into product_category (product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.description = 'PRODUCT1' and c.description = 'CAT1';

insert into product_category (product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.description = 'PRODUCT2' and c.description = 'CAT1';

insert into product_category (product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.description = 'PRODUCT1' and c.description = 'CAT3';

insert into product_category (product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.description = 'PRODUCT4' and c.description = 'CAT3';