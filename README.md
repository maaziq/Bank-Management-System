# Bank-Management-System

Bank Management System

Overview

The Bank Management System is a backend RESTful web application developed using Spring Boot that enables efficient management of banks, customer accounts, and branch addresses. The application provides APIs for performing banking operations such as account creation, account management, balance handling, and bank information management.

This project demonstrates the implementation of Spring Boot, Spring Data JPA, Hibernate, PostgreSQL, REST APIs, and layered architecture following industry-standard development practices.

⸻

Features

Bank Management

* Create and manage bank records
* Store bank details such as:
    * Bank Name
    * IFSC Code
    * Branch Name
    * Contact Number
* Associate each bank with its address

Address Management

* Maintain branch address information
* One-to-One relationship between Bank and Address
* Store:
    * Street
    * City
    * State
    * Pincode

Account Management

* Create customer accounts
* View account details
* Manage account balances
* Associate multiple accounts with a single bank
* Support for different account types

Transaction Operations

* Deposit amount into an account
* Retrieve account details using Account ID or Account Number
* Update account information
* Manage account balance securely

⸻

Technology Stack

Technology	Purpose
Java 25	Programming Language
Spring Boot	Application Framework
Spring Data JPA	Data Persistence
Hibernate	ORM Framework
PostgreSQL	Database
Maven	Dependency Management
REST API	Communication Layer
Lombok (Optional)	Boilerplate Code Reduction
Git & GitHub	Version Control

⸻

Project Architecture

The application follows a layered architecture:

Controller Layer
       ↓
Service Layer
       ↓
Repository Layer
       ↓
PostgreSQL Database

Layers

Controller Layer

Handles incoming HTTP requests and returns API responses.

Service Layer

Contains business logic and validation.

Repository Layer

Interacts with the database using Spring Data JPA.

Database Layer

Stores bank, account, and address information.

⸻

Entity Relationship

Bank

* One Bank → One Address
* One Bank → Many Accounts

Address

* One Address → One Bank

Account

* Many Accounts → One Bank

Bank
 │
 ├── Address (1:1)
 │
 |
 └── Accounts (1:N)

⸻

API Endpoints

Bank APIs

Method	Endpoint	Description
POST	/api/banks	Create Bank
GET	/api/banks	Get All Banks
GET	/api/banks/{id}	Get Bank By ID
PUT	/api/banks/{id}	Update Bank
DELETE	/api/banks/{id}	Delete Bank

Account APIs

Method	Endpoint	Description
POST	/api/accounts	Create Account
GET	/api/accounts	Get All Accounts
GET	/api/accounts/{id}	Get Account By ID
PUT	/api/accounts/{id}	Update Account
DELETE	/api/accounts/{id}	Delete Account

Transaction APIs

Method	Endpoint	Description
PUT	/api/accounts/deposit/{accountNumber}	Deposit Amount
GET	/api/accounts/account-number/{accountNumber}	Find Account By Account Number

⸻

Sample JSON Request

Create Bank

{
  "bankName": "State Bank of India",
  "ifscCode": "SBIN0001234",
  "branch": "Patna Main Branch",
  "contact": 9876543210,
  "address": {
    "street": "Fraser Road",
    "city": "Patna",
    "state": "Bihar",
    "pincode": 800001
  }
}

Create Account

{
  "accountNumber": 123456789012,
  "accountHolder": "Maaz Equbal",
  "accountType": "Savings",
  "balance": 50000.0,
  "bankAcc": {
    "bankId": 1
  }
}

Deposit Amount

{
  "amount": 10000
}

⸻

Getting Started

Prerequisites

* Java 25
* Maven 3.9+
* PostgreSQL
* Git
* Eclipse IDE / IntelliJ IDEA

Clone Repository

git clone https://github.com/your-username/bank-management-system.git
cd bank-management-system

Configure Database

Update the application.properties file:

spring.datasource.url=jdbc:postgresql://localhost:5432/bankdb
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Run Application

mvn spring-boot:run

Application will start at:

http://localhost:8080

⸻

Learning Objectives

This project demonstrates:

* Spring Boot Application Development
* REST API Design
* CRUD Operations
* Layered Architecture
* Hibernate & JPA Mappings
* One-To-One Mapping
* One-To-Many Mapping
* JSON Serialization Handling
* PostgreSQL Integration
* Maven Project Management
* Exception Handling
* Git & GitHub Workflow

⸻

Future Enhancements

* Withdraw Amount API
* Fund Transfer Between Accounts
* Transaction History
* Authentication & Authorization using Spring Security
* JWT Based Security
* Pagination and Sorting
* Global Exception Handling
* Swagger/OpenAPI Documentation
* Docker Containerization

⸻

Author

Maaz Equbal

B.Tech (CSE - IoT & Cyber Security)

Java Full Stack Developer

⸻

License

This project is developed for educational and learning purposes.