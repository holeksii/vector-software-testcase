-- 1. Select product with product name that begins with ‘C’.
SELECT * FROM Products
WHERE name LIKE 'C%';

-- 2. Select product with the smallest price.
SELECT * FROM Products
WHERE price = (SELECT MIN(price) FROM Products);

-- 3. Select cost of all products from the USA.
SELECT SUM(price) AS total_cost
FROM Products
INNER JOIN Suppliers ON Products.supplier_id = Suppliers.id
WHERE Suppliers.country = 'USA';

-- 4. Select suppliers that supply Condiments.
SELECT Suppliers.*
FROM Suppliers
INNER JOIN Products ON Suppliers.id = Products.supplier_id
INNER JOIN Categories ON Products.category_id = Categories.id
WHERE Categories.name = 'Condiments';

-- 5. Add to the database a new supplier and a new product.
INSERT INTO Suppliers (id, name, city, country)
VALUES (6, 'Norske Meierier', 'Lviv', 'Ukraine');

INSERT INTO Products (id, name, price, supplier_id, category_id)
VALUES (
  6,
  'Green tea',
  10,
  (SELECT id FROM Suppliers WHERE name = 'Norske Meierier'),
  (SELECT id FROM Categories WHERE name = 'Beverages')
);
