CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    registered DATE,
    email_address varchar(255) UNIQUE,
    title VARCHAR(5),
    first_name varchar(255),
    last_name varchar(255),
    address_line_1 varchar(255),
    address_line_2 varchar(255),
    city varchar(255),
    postcode varchar(10),
    phone_number varchar(20),
    password varchar(255),
    CONSTRAINT title_enum_values
    CHECK (title IN ('Mr', 'Mrs', 'Ms', 'Other'))
);
