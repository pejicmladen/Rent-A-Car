# Rent A Car

Rent A Car is a Java desktop application for managing car rental workflows. It allows users to browse available vehicles, create rental requests, view rented cars, and lets administrators manage the vehicle fleet and rental contracts.

## Features

- User registration, login, logout, and session handling
- Vehicle search and filtering by make, model, year, price, transmission, and availability dates
- Rental request creation with date-based pricing
- Calendar view for unavailable vehicle dates
- Admin tools for adding, updating, and deleting cars
- Admin contract management for approving or deleting rental contracts

## Tech Stack

- Java 17
- Java Swing
- JDBC
- MySQL
- JCalendar 1.4
- NetBeans Ant project configuration

## Project Structure

```text
src/rentacar
+-- Main.java
+-- domain
|   +-- CarModel.java
|   +-- ContractsModel.java
|   +-- UserModel.java
+-- repository
|   +-- CarRepository.java
|   +-- ContractRepository.java
|   +-- UserRepository.java
|   +-- connection
|   |   +-- DatabaseAccess.java
|   +-- impl
|       +-- CarRepositoryImpl.java
|       +-- ContractRepositoryImpl.java
|       +-- UserRepositoryImpl.java
+-- ui
    +-- form
    +-- session
```

## Requirements

- JDK 17 or newer
- MySQL Server
- MySQL Connector/J 8.0.32
- JCalendar 1.4
- NetBeans or IntelliJ IDEA

## Database Setup

The application currently expects a local MySQL database connection in `DatabaseAccess.java`:

```java
String url = "jdbc:mysql://localhost:3306/rent_a_car";
String user = "root";
String password = "root";
```

Before running the app:

1. Create a MySQL database named `rent_a_car`.
2. Create the required tables for users, cars, and contracts.
3. Update the database username and password in `src/rentacar/repository/connection/DatabaseAccess.java` if your local MySQL credentials are different.

## Running the Project

### Option 1: NetBeans

1. Open the project folder in NetBeans.
2. Add the required external libraries:
   - MySQL Connector/J
   - JCalendar 1.4
3. Build and run the project.

### Option 2: IntelliJ IDEA

1. Open the project folder in IntelliJ IDEA.
2. Mark `src` as the source root if needed.
3. Add the required external JAR files to the module dependencies.
4. Run `rentacar.Main`.

## Main Workflows

- Guests can browse and search cars.
- Registered users can log in, search available cars by date, and create rental requests.
- Logged-in users can view their rented cars and contract approval status.
- Admin users can manage the car catalog and approve pending rental contracts.

## Notes

- The project uses direct JDBC queries through repository classes.
- External library paths may need to be updated for each local development machine.
- The database schema is not currently included in this repository.
