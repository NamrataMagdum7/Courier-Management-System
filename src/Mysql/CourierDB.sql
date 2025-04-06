create database courier
use courier
CREATE TABLE User (
    UserID INT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Password VARCHAR(255),
    ContactNumber VARCHAR(20),
    Address TEXT
);

CREATE TABLE Courier (
    CourierID INT PRIMARY KEY,
    SenderName VARCHAR(255),
    SenderAddress TEXT,
    ReceiverName VARCHAR(255),
    ReceiverAddress TEXT,
    Weight DECIMAL(5, 2),
    Status VARCHAR(50),
    TrackingNumber VARCHAR(20) UNIQUE,
    DeliveryDate DATE
);

CREATE TABLE CourierServices (
    ServiceID INT PRIMARY KEY,
    ServiceName VARCHAR(100),
    Cost DECIMAL(8, 2)
);

CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    ContactNumber VARCHAR(20),
    Role VARCHAR(50),
    Salary DECIMAL(10, 2)
);

CREATE TABLE Location (
    LocationID INT PRIMARY KEY,
    LocationName VARCHAR(100),
    Address TEXT
);

CREATE TABLE Payment (
    PaymentID INT PRIMARY KEY,
    CourierID INT,
    LocationID INT,
    Amount DECIMAL(10, 2),
    PaymentDate DATE,
    FOREIGN KEY (CourierID) REFERENCES Courier(CourierID),
    FOREIGN KEY (LocationID) REFERENCES Location(LocationID)
);

-- Sample Data Insertion
INSERT INTO User VALUES
(1, 'Alice', 'alice@mail.com', 'pass123', '1234567890', 'Address A'),
(2, 'Bob', 'bob@mail.com', 'pass456', '9876543210', 'Address B'),
(3, 'Charlie', 'charlie@mail.com', 'pass789', '1122334455', 'Address C'),
(4, 'David', 'david@mail.com', 'pass321', '9988776655', 'Address D'),
(5, 'Eve', 'eve@mail.com', 'pass654', '7766554433', 'Address E'),
(6, 'Frank', 'frank@mail.com', 'pass987', '6655443322', 'Address F'),
(7, 'Grace', 'grace@mail.com', 'pass159', '5544332211', 'Address G'),
(8, 'Heidi', 'heidi@mail.com', 'pass753', '4433221100', 'Address H'),
(9, 'Ivan', 'ivan@mail.com', 'pass852', '3322110099', 'Address I'),
(10, 'Judy', 'judy@mail.com', 'pass951', '2211009988', 'Address J');

INSERT INTO Courier VALUES
(1, 'Alice', 'Address A', 'Bob', 'Address B', 1.5, 'Delivered', 'TRK123', '2025-04-01'),
(2, 'Charlie', 'Address C', 'David', 'Address D', 2.0, 'In Transit', 'TRK124', NULL),
(3, 'Eve', 'Address E', 'Frank', 'Address F', 3.2, 'Delivered', 'TRK125', '2025-04-02'),
(4, 'Grace', 'Address G', 'Heidi', 'Address H', 0.8, 'Pending', 'TRK126', NULL),
(5, 'Ivan', 'Address I', 'Judy', 'Address J', 5.5, 'Delivered', 'TRK127', '2025-04-03'),
(6, 'Alice', 'Address A', 'David', 'Address D', 1.0, 'Delivered', 'TRK128', '2025-04-04'),
(7, 'Bob', 'Address B', 'Charlie', 'Address C', 2.5, 'In Transit', 'TRK129', NULL),
(8, 'Frank', 'Address F', 'Eve', 'Address E', 4.0, 'Pending', 'TRK130', NULL),
(9, 'Heidi', 'Address H', 'Grace', 'Address G', 1.3, 'Delivered', 'TRK131', '2025-04-05'),
(10, 'Judy', 'Address J', 'Ivan', 'Address I', 3.0, 'In Transit', 'TRK132', NULL);

INSERT INTO CourierServices VALUES
(1, 'Standard', 50.00),
(2, 'Express', 100.00),
(3, 'Same Day', 150.00);

INSERT INTO Employee VALUES
(1, 'John Doe', 'john1@mail.com', '1234560000', 'Delivery Agent', 30000.00),
(2, 'Jane Smith', 'jane@mail.com', '9876500000', 'Manager', 50000.00),
(3, 'Emily Davis', 'emily@mail.com', '1122300000', 'Delivery Agent', 32000.00),
(4, 'Michael Brown', 'michael@mail.com', '9988700000', 'Clerk', 25000.00),
(5, 'Chris John', 'chris@mail.com', '7766500000', 'Delivery Agent', 31000.00);

INSERT INTO Location VALUES
(1, 'Warehouse A', 'Location A Address'),
(2, 'Warehouse B', 'Location B Address'),
(3, 'Hub Central', 'Central Location Address');

INSERT INTO Payment VALUES
(1, 1, 1, 75.00, '2025-04-01'),
(2, 3, 2, 120.00, '2025-04-02'),
(3, 5, 1, 60.00, '2025-04-03'),
(4, 6, 3, 80.00, '2025-04-04'),
(5, 9, 2, 55.00, '2025-04-05'),
(6, 2, 1, 95.00, '2025-04-01'),
(7, 4, 3, 45.00, '2025-04-02'),
(8, 7, 1, 130.00, '2025-04-03'),
(9, 8, 2, 70.00, '2025-04-04'),
(10, 10, 3, 100.00, '2025-04-05');