// Example queries to create books
INSERT INTO books(title, author) VALUES ("Harry Potter", "J. K. Rowling");
INSERT INTO books(title, author) VALUES ("Emma", "Jane Austen");
INSERT INTO books(title, author) VALUES ("Wojna i pokój", "Lew Tolstoj");
INSERT INTO books(title, author) VALUES ("Idiota", "Fiodor Dostojewski");
INSERT INTO books(title, author) VALUES ("Duma i Uprzedzenia", "Jane Austen");
INSERT INTO books(title, author) VALUES ("Lalka", "Boleslaw Prus");
INSERT INTO books(title, author) VALUES ("Biblia", NULL);
INSERT INTO books(title, author) VALUES ("Pan Tadeusz", "Adam Mickiewicz");

// Example queries to create users
INSERT INTO users(first_name, last_name, age, pesel) VALUES ("Kowalska", "Anna", 18, 12345678901);
INSERT INTO users(first_name, last_name, age, pesel) VALUES ("Nowak", "Jan", 38, 12345678902);
INSERT INTO users(first_name, last_name, age, pesel) VALUES ("Sobieski", "Bolek", 52, 12345678903);
INSERT INTO users(first_name, last_name, age, pesel) VALUES ("Jankowska", "Maria", 43, 12345678904);
INSERT INTO users(first_name, last_name, age, pesel) VALUES ("Urbaniak", "Halyna", 75, 1234567);
INSERT INTO users(first_name, last_name, age, pesel) VALUES ("Popielinski", "Mariusz", 11, 12345678904365);

// Example queries to create orders
INSERT INTO orders(book_id, borrowed_by, date_of_borrow, date_of_return, date_to_return) VALUES (1, 1, '2018-04-10', NULL, '2018-04-30');
INSERT INTO orders(book_id, borrowed_by, date_of_borrow, date_of_return, date_to_return) VALUES (2, 2, '2018-04-15', '2018-04-27', '2018-04-30');
INSERT INTO orders(book_id, borrowed_by, date_of_borrow, date_of_return, date_to_return) VALUES (3, 3, '2018-04-20', NULL, '2018-04-26');
INSERT INTO orders(book_id, borrowed_by, date_of_borrow, date_of_return, date_to_return) VALUES (2, 2, '2018-04-25', '2018-04-27', '2018-04-30');