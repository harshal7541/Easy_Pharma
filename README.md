# Easy_Pharma
Team Members
--Harshal Badgujar
--Sujit Badgujar
--Girish Giradkar
--Chandrashekar Padam
--Harshal patil
--Saket Bhavsar

Database Query 
---create database easypharma;
 use easypharma;
 
 CREATE TABLE users(
  user_id int NOT NULL AUTO_INCREMENT,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL,
  email varchar(50) NOT NULL,
  password varchar(150) NOT NULL,
  mobile_no varchar(15) NOT NULL,
  role varchar(20) NOT NULL,
  create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
updated_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  isactive tinyint DEFAULT '1',
  PRIMARY KEY (user_id),
  UNIQUE KEY mobile_no_UNIQUE (mobile_no),
  UNIQUE KEY email_UNIQUE (email)
);

CREATE TABLE order_items(
  order_items_id int NOT NULL AUTO_INCREMENT,
  order_id int DEFAULT NULL,
  price double DEFAULT NULL,
  product_id int DEFAULT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (order_items_id)
);

CREATE TABLE address(
  address_id int NOT NULL AUTO_INCREMENT,
  street varchar(100) DEFAULT NULL,
  city varchar(50) NOT NULL,
  pincode int NOT NULL,
  state varchar(50) DEFAULT NULL,
  house_no int DEFAULT NULL,
  user_id int NOT NULL,
  created_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (address_id),
  KEY user_id (user_id),
  CONSTRAINT address_ibfk_1 FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE products(
  product_id int NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  description varchar(500) DEFAULT NULL,
  price double NOT NULL,
  stocks int NOT NULL,
  created_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  product_thumbnail varchar(200) DEFAULT NULL,
product_type_id int NOT NULL,
  manfact_date timestamp NULL DEFAULT NULL,
  expiry_date timestamp NULL DEFAULT NULL,
  PRIMARY KEY (product_id),
  KEY product_type_id (product_type_id),
  CONSTRAINT products_ibfk_1 FOREIGN KEY (product_type_id) REFERENCES product_types (id) ON DELETE CASCADE
);

CREATE TABLE product_types(
  id int NOT NULL AUTO_INCREMENT,
  type_name varchar(100) NOT NULL,
  type_thumbnail varchar(200) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE cart(
  cart_id int NOT NULL AUTO_INCREMENT,
  quantity int DEFAULT NULL,
  product_id int DEFAULT NULL,
user_id int DEFAULT NULL,
  created_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (cart_id),
  KEY user_id (user_id),
  KEY product_id (product_id),
  CONSTRAINT cart_ibfk_1 FOREIGN KEY (user_id) REFERENCES users (user_id),
  CONSTRAINT cart_ibfk_2 FOREIGN KEY (product_id) REFERENCES products (product_id)
);

create table orders (order_id INT PRIMARY KEY AUTO_INCREMENT ,  order_amount DOUBLE ,order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,user_id INT,address_id INT);
alter table orders ADD FOREIGN KEY (address_id) REFERENCES address (address_id);

create table contactus(id int PRIMARY KEY AUTO_INCREMENT, name varchar(50), email varchar(50), subject varchar(200), message TEXT);

insert into users(first_name,last_name,email,password,mobile_no,role)  values('Girish','giradkar','girish@gmail.com','admin','8624950045','admin');

CREATE TABLE cart_item(
  cart_id INT NOT NULL AUTO_INCREMENT,
  quantity INT NULL,
  product_id INT NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (cart_id),
  FOREIGN KEY(product_id) REFERENCES products(product_id),
  FOREIGN KEY(user_id) REFERENCES users(user_id)
  );
  
  insert into users(first_name,last_name,email,password,mobile_no,role)  values('Harshal','Badgujar','harshal@gmail.com','$2a$10$dYJv271qunK5gSx8lyCF5eWqtIa0OLIsMcq5F6gjMgFa3CDfCTlr.','9657737292','admin');

