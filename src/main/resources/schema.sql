CREATE DATABASE library;

USE library;

CREATE TABLE books (
id INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(20),
author VARCHAR(20)
);

CREATE TABLE users (
id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
age INT NOT NULL,
pesel BIGINT NOT NULL
);

CREATE TABLE orders (
id INT AUTO_INCREMENT PRIMARY KEY,
book_id INT NOT NULL,
borrowed_by INT,
date_of_borrow DATE,
date_of_return DATE,
date_to_return DATE,

FOREIGN KEY (borrowed_by) REFERENCES users(id),
FOREIGN KEY (book_id) REFERENCES books(id)
);

CREATE TABLE `hibernate_sequence` ( `next_val` bigint(20) DEFAULT NULL );
