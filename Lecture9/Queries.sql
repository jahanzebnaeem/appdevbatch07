-- CRUD (Create = Insert, Read = Select, Update = Update & Delete = Delete)

-- INSERT INTO Country (Name, Population) VALUES ('Iran', 700000);
-- INSERT INTO City (CountryId, Name, Population) VALUES (1, 'Lahore', 700000);
-- INSERT INTO City (CountryId, Name, Population) VALUES (1, 'Karachi', 700000);
-- INSERT INTO City (CountryId, Name, Population) VALUES (1, 'Islamabad', 700000);
-- INSERT INTO City (CountryId, Name, Population) VALUES (2, 'Beging', 700000);
-- INSERT INTO City (CountryId, Name, Population) VALUES (2, 'Shanghi', 700000);
-- SELECT * FROM Country;
-- SELECT * FROM City;

-- UPDATE City SET Name = 'Bejing' WHERE id = 4;
-- SELECT * FROM City;
-- DELETE FROM City WHERE id = 5;
-- SELECT * FROM City;

-- SELECT Country.Name, City.Name FROM Country INNER JOIN City ON Country.id = City.CountryId;
-- SELECT Country.Name, City.Name FROM Country LEFT JOIN City ON Country.id = City.CountryId;
-- SELECT Country.Name, City.Name FROM Country JOIN City ON Country.id = City.CountryId;

-- SELECT Name, Population FROM Country
-- UNION 
-- SELECT Name, Population FROM City

-- SELECT Name, Population FROM Country
-- UNION ALL
-- SELECT Name, Population FROM City

-- SELECT Count(id), CountryId FROM City GROUP BY CountryId;
-- SELECT Count(id), CountryId FROM City GROUP BY CountryId HAVING Count(id) > 1;

-- SELECT DISTINCT Country.id FROM Country INNER JOIN City ON Country.id = City.CountryId WHERE Country.Name = 'Pakistan';

-- SELECT Name FROM City WHERE EXISTS (SELECT id FROM Country WHERE CountryId = Country.id AND Country.Name = 'Pakistan');

-- SELECT * FROM Country LIMIT 1;
