SET MODE PostgreSQL;

CREATE DATABASE student_motivation_app;
\c student_motivation_app;

CREATE TABLE IF NOT EXISTS admins (
  id  SERIAL PRIMARY KEY,
  name VARCHAR,
  email VARCHAR
);


CREATE TABLE IF NOT EXISTS users (
  id  SERIAL PRIMARY KEY,
  name VARCHAR,
  age int,
  email VARCHAR,
  department VARCHAR,
  phoneNumber int,
  role varchar
);

CREATE TABLE IF NOT EXISTS motivation (
  id  SERIAL PRIMARY KEY,
  content VARCHAR,
  userId INT
);

CREATE TABLE IF NOT EXISTS categories (
  id  SERIAL PRIMARY KEY,
  categoryName VARCHAR,
  categoryDescription VARCHAR
);


CREATE DATABASE student_motivation_app_test WITH TEMPLATE student_motivation_app;