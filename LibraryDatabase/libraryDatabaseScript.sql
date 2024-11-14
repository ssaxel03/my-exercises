DROP DATABASE IF EXISTS libraryDatabase;
CREATE DATABASE libraryDatabase;
USE libraryDatabase;

CREATE TABLE authors(
    id INTEGER AUTO_INCREMENT,
    name CHAR(15) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE publishers(
    id INTEGER AUTO_INCREMENT,
    name CHAR(15) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE books(
    id INTEGER AUTO_INCREMENT,
    name CHAR(15) NOT NULL UNIQUE,
    author_id INTEGER NOT NULL,
    publisher_id INTEGER NOT NULL,
    year_published YEAR NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(author_id) REFERENCES authors(id),
    FOREIGN KEY(publisher_id) REFERENCES publishers(id)
);

CREATE TABLE users(
    id INTEGER AUTO_INCREMENT,
    name CHAR(15) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE loans(
    id INTEGER AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    date DATE,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(book_id) REFERENCES books(id)
);

INSERT INTO authors(name) VALUES ("Tolstoi");
INSERT INTO authors(name) VALUES ("Fake Tolstoi");
INSERT INTO authors(name) VALUES ("Anderson");

INSERT INTO publishers(name) VALUES ("Livros fixes");
INSERT INTO publishers(name) VALUES ("Livros meh");
INSERT INTO publishers(name) VALUES ("Livros FCP");

INSERT INTO books(name, author_id, publisher_id, year_published)
    VALUES ("Kamasutra", 3, 1, 2037);
INSERT INTO books(name, author_id, publisher_id, year_published)
    VALUES ("Vida militar", 3, 3, 2020);
INSERT INTO books(name, author_id, publisher_id, year_published)
    VALUES ("Pa ya e tal", 1, 2, 1946);

INSERT INTO users(name)
    VALUES ("Filipe");
INSERT INTO users(name)
    VALUES ("Jorge");
INSERT INTO users(name)
    VALUES ("Cristina");

INSERT INTO loans(user_id, book_id, date) 
    VALUES (1, 1, "2038-02-18");
INSERT INTO loans(user_id, book_id, date) 
    VALUES (3, 2, "2021-12-25");
INSERT INTO loans(user_id, book_id, date) 
    VALUES (3, 3, "2047-01-14");