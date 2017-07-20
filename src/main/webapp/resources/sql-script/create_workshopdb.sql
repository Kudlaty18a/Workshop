CREATE TABLE workshopOwner(
	workshopOwnerID int NOT NULL AUTO_INCREMENT,
    username varchar(50),
    password varchar(50),
    PRIMARY KEY (workshopOwnerID)
);
    
CREATE TABLE workshop(
	workshopID int NOT NULL AUTO_INCREMENT,
    workshopName varchar(50),
    postcode varchar(50),
    city varchar(50),
    street varchar(50),
    streetNumber int,
    workshopOwnerID int,
    PRIMARY KEY (workshopID),
    FOREIGN KEY (workshopOwnerID) REFERENCES workshopOwner(workshopOwnerID)
);
    
CREATE TABLE customer(
	customerID int NOT NULL AUTO_INCREMENT,
    firstName varchar(50),
    secondName varchar(50),
    phoneNumber varchar(50),
    workshopID int,
    PRIMARY KEY (customerID),
    FOREIGN KEY (workshopID) REFERENCES workshop(workshopID)
);

CREATE TABLE carOwner(
	carOwnerID int NOT NULL AUTO_INCREMENT,
    firstName varchar(50),
    secondName varchar(50),
    phoneNumber varchar(50),
    workshopID int,
    PRIMARY KEY (carOwnerID),
    FOREIGN KEY (workshopID) REFERENCES workshop(workshopID)
);

CREATE TABLE car(
	carID int NOT NULL AUTO_INCREMENT,
    brand varchar(50),
    model varchar(50),
    year varchar(50),
    customerID int,
    carOwnerID int,
    PRIMARY KEY (carID),
    FOREIGN KEY (customerID) REFERENCES customer(customerID),
    FOREIGN KEY (carOwnerID) REFERENCES carOwner(carOwnerID)
);

CREATE TABLE service(
	serviceID int NOT NULL AUTO_INCREMENT,
    registrationNumber varchar(50),
    price double,
    carID int,
    customerID int,
    workshopID int,
    PRIMARY KEY (serviceID),
    FOREIGN KEY (carID) REFERENCES car(carID),
    FOREIGN KEY (customerID) REFERENCES customer(customerID),
    FOREIGN KEY (workshopID) REFERENCES workshop(workshopID)
);

CREATE TABLE actionHistory(
	actionHistoryID int NOT NULL AUTO_INCREMENT,
    actionDate date,
    operation varchar(50),
    price double,
    serviceID int,
    PRIMARY KEY (actionHistoryID),
    FOREIGN KEY (serviceID) REFERENCES service(serviceID)
);

CREATE TABLE concractor(
	contractorID int NOT NULL AUTO_INCREMENT,
    contractorName varchar(50),
    postcode varchar(50),
    city varchar(50),
    street varchar(50),
    streetNumber int,
    workshopID int,
    PRIMARY KEY (contractorID),
    FOREIGN KEY (workshopID) REFERENCES workshop(workshopID)
);

CREATE TABLE product(
	productID int NOT NULL AUTO_INCREMENT,
    productName varchar(50),
    price double,
    contractorID int,
    PRIMARY KEY (productID),
    FOREIGN KEY (contractorID) REFERENCES concractor(contractorID)
);
