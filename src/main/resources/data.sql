CREATE TABLE users (
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    phone varchar(300) NOT NULL DEFAULT '',
    address_country varchar(300) NOT NULL DEFAULT '',
    address_city varchar(300) NOT NULL DEFAULT '',
    user_name varchar(300) NOT NULL DEFAULT '',
    user_password varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

INSERT INTO users (first_name, last_name, email, phone, address_country, address_city, user_name, user_password) VALUES
('John', 'Doe', '7IaDZ@example.com', '1234567890', 'USA', 'New York', 'johndoe', 'Password123!'),
('Jane', 'Doe', 'jane@doe', '0987654321', 'Canada', 'Toronto', 'janedoe', 'lord44$'),
('Bob', 'Smith', 'bob@smith', '5555555555', 'USA', 'Los Angeles', 'bobsmith', 'wordaA55%'),
('Alice', 'Johnson', 'alice@johnson', '1111111111', 'UK', 'London', 'alicejohnson', 'pWerT45!'),
('Mike', 'Brown', 'mike@brown', '2222222222', 'Australia', 'Sydney', 'mikebrown', 'Root@123'),
('Emily', 'Davis', 'emily@davis', '3333333333', 'France', 'Paris', 'emilydavis', 'Secret123!'),
('David', 'Wilson', 'david@wilson', '4444444444', 'Germany', 'Berlin', 'davidwilson', 'passw0rd!');

CREATE TABLE items (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(300) NOT NULL DEFAULT '',
    price int NOT NULL DEFAULT 0,
    image varchar(300) NOT NULL DEFAULT '',
    in_stock int NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

INSERT INTO items (name, price, image, in_stock) VALUES
('Smartphone', 500, 'http://tinyurl.com/3nnp78ap', 50),
('Laptop', 1000, 'http://tinyurl.com/mrd6ana5', 30),
('Headphones', 100, 'http://tinyurl.com/44rmpzh7', 100),
('Coffee Maker', 50, 'http://tinyurl.com/jd7hfew4', 20),
('Bluetooth Speaker', 80, 'http://tinyurl.com/4374xmbw', 40),
('Digital Camera', 200, 'http://tinyurl.com/3z9t9h8m', 15),
('Fitness Tracker', 40, 'http://tinyurl.com/2mrcj3a2', 60),
('Microwave Oven', 90, 'http://tinyurl.com/33etj3cc', 25),
('Toaster', 30, 'http://tinyurl.com/2r5den4n', 35),
('Electric Kettle', 50, 'http://tinyurl.com/5zx7rs94', 50),
('Desk Lamp', 115, 'http://tinyurl.com/ucfem35j', 70),
('External Hard Drive', 80, 'http://tinyurl.com/42a6cnjn', 10),
('Wireless Mouse', 25, 'http://tinyurl.com/2b5ns86r', 45),
('Backpack', 50, 'http://tinyurl.com/yc5k49zw', 55),
('Gaming Console', 500, 'http://tinyurl.com/mt4aw29x', 5),
('Tablet', 1500, 'http://tinyurl.com/bdete5d8', 20),
('Printer', 50, 'http://tinyurl.com/5aupfjtj', 15),
('Office Chair', 150, 'http://tinyurl.com/ywzm23fc', 30),
('Smart TV', 700, 'http://tinyurl.com/24ms7dmd', 10),
('Digital Watch', 60, 'http://tinyurl.com/yw5fxpeh', 40),
('Drones', 200, 'http://tinyurl.com/3wvf7sed', 8),
('Sunglasses', 30, 'http://tinyurl.com/mpewpza3', 50),
('Power Bank', 30, 'http://tinyurl.com/36462f5j', 25);

CREATE TABLE favorites (
    user_id int NOT NULL ,
    item_id int NOT NULL ,
    PRIMARY KEY (user_id, item_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (item_id) REFERENCES items(id)
);

CREATE TABLE orders (
    id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL ,
    order_status varchar(255) NOT NULL DEFAULT 'TEMP',
    order_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_price int NOT NULL DEFAULT 0,
    order_shipping_address varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO orders (user_id, order_status, order_date, total_price, order_shipping_address) VALUES
(1, 'CLOSED', '2023-04-01 10:00:00', 500, 'USA New York'),
(2, 'TEMP', '2023-04-02 12:00:00', 1000, 'Canada Toronto'),
(3, 'TEMP', '2023-04-03 14:00:00', 210 , 'USA Los Angeles');

CREATE TABLE order_items (
    order_id int NOT NULL ,
    item_id int NOT NULL ,
    quantity int NOT NULL DEFAULT 0,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (item_id) REFERENCES items(id)
);

INSERT INTO order_items (order_id, item_id, quantity) VALUES
(1, 1, 1),
(2, 3, 3),
(2, 15, 1),
(2, 6, 1),
(3, 7, 1),
(3, 8, 1),
(3, 9, 1),
(3, 10, 1);






