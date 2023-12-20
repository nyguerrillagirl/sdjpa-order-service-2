drop table if exists order_header;

create table order_header (
    id SERIAL PRIMARY KEY,
    shipping_address varchar(30),
    shipping_city varchar(30),
    shipping_state varchar(30),
    shipping_zip_code varchar(30),
    bill_to_address varchar(30),
    bill_to_city varchar(30),
    bill_to_state varchar(30),
    bill_to_zip_code varchar(30),
    order_status varchar(30),
    created_date timestamp,
    last_modified_date timestamp,
    customer_id INT REFERENCES customer(id),
    version INTEGER
);