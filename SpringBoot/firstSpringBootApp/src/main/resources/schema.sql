DROP TABLE IF EXISTS books;

CREATE TABLE  books(
id INT AUTO_INCREMENT PRIMARY KEY,
author_id INT,
title VARCHAR(250) NOT NULL,
priceOld  VARCHAR(250) DEFAULT NULL,
price VARCHAR(250) DEFAULT NULL
);
CREATE TABLE  authors(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(250) NOT NULL,
                       surname VARCHAR(250) NOT NULL
);