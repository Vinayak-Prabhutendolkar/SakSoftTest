SakSoft LTD Test assesment

*********************************** DATABASE ***********************************
ORM: Spring JPA
DataBase: MySQL

Create Teble Query:

CREATE TABLE `person` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(45) DEFAULT NULL,
  `Last_Name` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Age` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
)

Sample data:
INSERT INTO `employee_directory`.`person` (`Id`, `FirstName`, `LastName`, `Email`, `Age`) VALUES ('1', 'Raj', 'Verma', 'raj.verma@imagine.com', '35');
INSERT INTO `employee_directory`.`person` (`Id`, `FirstName`, `LastName`, `Email`, `Age`) VALUES ('2', 'Vaibhav', 'Telang', 'v.telang@futureready.com', '29');
INSERT INTO `employee_directory`.`person` (`Id`, `FirstName`, `LastName`, `Email`, `Age`) VALUES ('3', 'Ketan', 'Bahadur', 'k.bahadur@infonext.com', '32');
INSERT INTO `employee_directory`.`person` (`Id`, `FirstName`, `LastName`, `Email`, `Age`) VALUES ('4', 'Abhishek', 'Raj', 'abhi.raj@softsol.com', '30');

***************************************** CRUD OPERATIONS **************************

URL: http://localhost:3000/person

Operations and description:

1. /getAll : Fetch all person's details from database.
2. /getEntityById : Fetch person's detail by Id from database.
3. /addEntity : Add person's detail into database.
4. /updateEntity : Update the person's information based on Id in database.
5. /deleteEntity : Delete the person's data by Id from database.

***************************************************************************************
   


