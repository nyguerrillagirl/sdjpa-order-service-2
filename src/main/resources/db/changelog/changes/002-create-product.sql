-- Creates Product table
CREATE TABLE product (
        id SERIAL PRIMARY KEY,
        created_date TIMESTAMP,
        last_modified_date TIMESTAMP,
        description VARCHAR(100),
        product_status VARCHAR(30),
        quantity_on_hand INTEGER
);