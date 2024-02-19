-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:33 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `AccountID` int(11) NOT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `AccountType` varchar(255) DEFAULT NULL,
  `Balance` decimal(10,2) DEFAULT NULL,
  `OpenDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`AccountID`, `CustomerID`, `AccountType`, `Balance`, `OpenDate`) VALUES
(1, 1, 'Savings', 1000.00, '2024-02-18'),
(2, 8, 'equity accaunt', 500000.00, '2024-01-11'),
(3, 3, 'Investment', 5000.00, '2024-02-18'),
(4, 3, 'bk accaunt', 100000.00, '2012-02-01');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `id_number` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `martial_status` varchar(20) DEFAULT NULL,
  `DoB` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `id_number`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('', '', '', '', 'Male', '', '', '', ''),
('master', 'planner', '199223334342', '072345553', 'Male', 'married', '2003', 'master@gmail.com', '33'),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', 'Married', NULL, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

CREATE TABLE `branches` (
  `BranchID` int(11) NOT NULL,
  `BranchName` varchar(255) DEFAULT NULL,
  `Location` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `branches`
--

INSERT INTO `branches` (`BranchID`, `BranchName`, `Location`) VALUES
(1, 'Main Branch', 'New York'),
(2, 'Downtown Branch', 'Los Angeles'),
(4, 'Nyamata', 'Nyamata'),
(5, 'nyagatare branch', 'nygtr city'),
(6, 'muhanga branch', 'muhanga district'),
(7, 'ngarama branch', 'gatsibo district'),
(8, 'huye branch', 'huye town');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `Adress` varchar(255) DEFAULT NULL,
  `ContactNmbr` varchar(20) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `gender` enum('Male','Female') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `fname`, `lname`, `Adress`, `ContactNmbr`, `Email`, `gender`) VALUES
(2, 'Jane', 'Smith', '456 Elm St, Othertown', '987-654-3210', 'jane@example.com', 'Female'),
(3, 'Alex', 'Johnson', '789 Oak St, Another Town', '555-555-5555', 'alex@example.com', ''),
(4, 'fdfsgz', 'jystgzhn', 'sytaY', '567', 'GDFTYU', 'Male'),
(5, 'twiri', 'azana', 'karongi', '073222872', 'azatwiri@gmail.com', 'Male'),
(6, 'ishimwe', 'foibe', 'kabarore', '078455872', 'foibe@gmail.com', 'Male'),
(7, 'ishimwe', 'foibe', 'kabarore', '078455872', 'foibe@gmail.com', 'Female'),
(8, 'kabera', 'rukundo', 'gatungo', '07988777666', 'kaberrkund@gmail.com', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `EmployeeID` int(11) NOT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Position` varchar(255) DEFAULT NULL,
  `BranchID` int(11) DEFAULT NULL,
  `Telephone` varchar(20) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`EmployeeID`, `FirstName`, `LastName`, `Position`, `BranchID`, `Telephone`, `Email`) VALUES
(1, 'John', 'Doe', 'Manager', 1, '123-456-7890', 'john.doe@example.com'),
(2, 'Jane', 'Smith', 'Sales Associate', 2, '987-654-3210', 'jane.smith@example.com'),
(3, 'Alex', 'Johnson', 'Customer Service Representative', 3, '555-555-5555', 'alex.johnson@example.com'),
(4, 's\\c', 'A|svzcx ', 'vjh', 3, '098765', 'tfsh'),
(5, 'yvonne', 'nana', 'secretariat', 8, '0734567890', 'yvonne@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `LoanID` int(11) NOT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `LoanType` varchar(255) DEFAULT NULL,
  `Amount` decimal(10,2) DEFAULT NULL,
  `InterestRate` decimal(5,2) DEFAULT NULL,
  `StartDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`LoanID`, `CustomerID`, `LoanType`, `Amount`, `InterestRate`, `StartDate`) VALUES
(1, 1, 'Personal', 5000.00, 5.25, '2024-02-18'),
(2, 6, 'bursely', 500000.00, 50.00, '2023-03-02'),
(4, 2, 'long_term', 1000.00, 300.00, '2022-03-05'),
(5, 2, 'cbsag', 880000.00, 23.00, '2011-01-07');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `PaymentID` int(11) NOT NULL,
  `LoanID` int(11) DEFAULT NULL,
  `Amount` decimal(10,2) DEFAULT NULL,
  `PaymentDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`PaymentID`, `LoanID`, `Amount`, `PaymentDate`) VALUES
(1, 1, 500.00, '2024-02-18'),
(2, 2, 1000.00, '2024-02-18'),
(3, 3, 750.00, '2024-02-18'),
(4, 2, 55000.00, '2023-08-04'),
(5, 4, 1000.00, '2024-07-06'),
(6, 4, 60000.00, '2024-02-01');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `TransactionID` int(11) NOT NULL,
  `AccountID` int(11) DEFAULT NULL,
  `TransactionType` varchar(255) DEFAULT NULL,
  `Amount` decimal(10,2) DEFAULT NULL,
  `TransactionDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`TransactionID`, `AccountID`, `TransactionType`, `Amount`, `TransactionDate`) VALUES
(1, 1, 'Deposit', 1000.00, '2024-02-18'),
(2, 2, 'Withdrawal', 500.00, '2024-02-18'),
(3, 4, 'savings', 10000000.00, '2023-06-01'),
(4, 3, 'checking accaunts', 6000000.00, '2024-02-09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`AccountID`);

--
-- Indexes for table `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`BranchID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`LoanID`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`TransactionID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `AccountID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `branches`
--
ALTER TABLE `branches`
  MODIFY `BranchID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `EmployeeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `loan`
--
ALTER TABLE `loan`
  MODIFY `LoanID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `PaymentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `TransactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
