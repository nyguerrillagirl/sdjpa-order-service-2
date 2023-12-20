drop table if exists order_approval;

create table order_approval (
        id SERIAL PRIMARY KEY,
        approved_by varchar(50),
        created_date timestamp,
        last_modified_date timestamp,
        order_header_id INTEGER,
        CONSTRAINT fk_order_header
            FOREIGN KEY (order_header_id)
            REFERENCES order_header(id)
);

ALTER TABLE order_header
    ADD order_approval_id INTEGER;

ALTER TABLE order_header
    ADD CONSTRAINT fk_order_approval FOREIGN KEY(order_approval_id) REFERENCES order_approval(id)  ON DELETE CASCADE;

drop table if exists order_line;

create table order_line (
        id SERIAL PRIMARY KEY,
        created_date timestamp,
        last_modified_date timestamp,
        quantity_ordered INTEGER,
        order_header_id INTEGER REFERENCES order_header(id),
        product_id INTEGER REFERENCES product(id),
        version INTEGER
);

