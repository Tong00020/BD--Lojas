DROP PROCEDURE IF EXISTS Update_Product_Quantity;
DELIMITER $$

CREATE PROCEDURE Update_Product_Quantity(IN product_id INT)
BEGIN
	DECLARE product_quantity INT;
    DECLARE product_quantity_budget INT;
SELECT products.quantity INTO product_quantity FROM products WHERE products.id = product_id;
SELECT DISTINCT budget_details.amount INTO product_quantity_budget FROM budget_details INNER JOIN products prod ON budget_details.products_id = prod.id WHERE budget_details.products_id = product_id;
UPDATE products SET products.quantity = product_quantity - product_quantity_budget WHERE products.id = product_id;
END $$
DELIMITER ;

CALL Update_Product_Quantity(13);