--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables
CREATE TABLE sneaker (name varchar(255), brand varchar(255), color varchar(255), price smallmoney);
INSERT INTO sneaker VALUES ("Air Force 1","Nike", "White", "99.99");
INSERT INTO sneaker VALUES ("Air Max 95","Nike", "Black", "75.99");
INSERT INTO sneaker VALUES ("Air Max 97","Nike", "Red", "85.99");
INSERT INTO sneaker VALUES ("Lebron 8","Nike", "Yellow", "69.99");
INSERT INTO sneaker VALUES ("Question","Adidas", "Black", "45.99");
INSERT INTO sneaker VALUES ("yeezy","Adidas", "White", "99.99");
INSERT INTO sneaker VALUES ("Chuck Taylor","Converse", "Black", "39.99");
INSERT INTO sneaker VALUES ("Run Star","Converse", "White", "79.99");
INSERT INTO sneaker VALUES ("Shaq Attack","Reebok", "Blue", "45.99");
INSERT INTO sneaker VALUES ("Nano X 2","Reebok", "Black", "39.99");
