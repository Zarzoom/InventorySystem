USE InventoryData;

DROP TABLE Item;
DROP TABLE PantryList;
DROP TABLE Pantry;

CREATE TABLE Item(
Brand VARCHAR,
GenericName VARCHAR,
Price DECIMAL,
Size VARCHAR,
ItemID INT PRIMARY KEY,
);

CREATE TABLE PantryList(
    PantryName VARCHAR,
    PantryID INT Primary Key,
);

CREATE TABLE Pantry(
    PantryID INT FOREIGN KEY REFERENCES PantryList(PantryID),
    ItemID INT FOREIGN KEY REFERENCES    Item(ItemID),
    ItemQuantity INT,
);

-- BASICDATA
INSERT INTO Item(
    Brand, GenericName, Price, Size, ItemID)
    VALUES('Goodness Unearthed', 'Red Potato', 3.28, '5 Lb', 1),
    ('Goodness Unearthed', 'Yellow Potato', 3.18, '5 Lb', 2),
    ('Act II', 'Popcorn', 5.16, '16 Packages', 3),
    ('Great Value', 'Spaghetti', 0.92, '16 oz', 4),
    ('Puffs', 'Facial Tissue', 10.64, '4 boxes', 5),
    ('Creamette', 'Spaghetti', 1.34, '16 oz', 6),
    ('Great Value', 'Whole Milk', 3.38, '1 gallon', 7);

INSERT INTO PantryList(
    PantryName, PantryID)
    VALUES('Fridge', 1),
    ('Pantry', 2),
    ('Bathroom Closet', 3);

INSERT INTO Pantry(
    PantryID, ItemID,ItemQuantity)
    VALUES( 1, 7, 2),
    (2, 3, 1),
    (2, 2, 1),
    (2, 2, 1),
    (2, 1, 1),
    (3, 5, 6);

    -- JOINTS
Select Pantry.PantryID, Pantry.ItemID, Pantry.ItemQuantity, PantryList.PantryName, Item.Brand, Item.GemericName, Item.Price, Item.Size,
From PantryList
Right Join Pantry ON Pantry.PantryID=PantryList.PantryID
Inner Join Item On Item.ItemID= Pantry.ItemID
Where Pantry.PantryID=2