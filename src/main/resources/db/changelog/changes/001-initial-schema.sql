-- Creates Customer table
CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          customer_name VARCHAR(50),
                          address VARCHAR(30),
                          city VARCHAR(30),
                          state VARCHAR(30),
                          zip_code VARCHAR(30),
                          phone VARCHAR(20),
                          email VARCHAR(255),
                          created_date TIMESTAMP,
                          last_modified_date TIMESTAMP,
                          version INTEGER
);
