# SMART-KITCHEN-MANAGEMENT-DAO-pattern-with-SQL
My assignment for online course. With Java, SQL, DAO pattern, CRUD


### Assignment: Smart Kitchen Management System

#### Objective:
The goal of this assignment is to develop a Java application that interacts with a PostgreSQL database to manage a Smart Kitchen. The application will allow users to perform CRUD (Create, Read, Update, Delete) operations on a single table named `appliances`. This table will store information about various kitchen appliances.

#### Requirements:

1. **Database Setup:**
    - Use PostgreSQL as the database.
    - Create a database named `smart_kitchen`.
    - Inside the `smart_kitchen` database, create a table named `appliances` with the following columns:
        - `id` (Primary Key, Integer, Auto Increment)
        - `name` (Text)
        - `type` (Text) - (e.g., Refrigerator, Oven, Dishwasher)
        - `status` (Text) - (e.g., On, Off)
        - `usage_time` (Integer) - (Total usage time in minutes)

2. **Java Application Development:**
    - Develop a Java application that uses JDBC to interact with the `smart_kitchen` database.
    - Implement the following functionalities:
        - **Insert New Appliance:** Allow users to add new appliances to the database.
        - **List All Appliances:** Retrieve and display a list of all appliances from the database.
        - **Update Appliance:** Allow users to update the details of an existing appliance (e.g., change status, update usage time).
        - **Delete Appliance:** Allow users to delete an appliance from the database.
        - **Find Appliance:** Allow users to search for an appliance by name.

3. **Code Organization:**
    - Follow the provided code structure and adapt it to the Smart Kitchen context.
    - Implement the `ApplianceDao` interface with methods for each of the required functionalities.
    - Use the `ConnectionFactory` class to manage database connections.
    - Create an `Appliance` class to represent the appliance entity.

4. **Error Handling:**
    - Implement proper error handling for database operations.
    - Display meaningful error messages to the user in case of failures.

5. **Documentation:**
    - Document your code with comments explaining the purpose of methods and key code blocks.
    - Include instructions on how to set up the database and run the application.

#### Deliverables:

1. **Source Code:**
    - Provide all the Java source files required to run the application.
    - Include the SQL script for creating the `appliances` table in the `smart_kitchen` database.

2. **README File:**
    - Include a README file with:
        - Instructions on how to set up the PostgreSQL database and create the required table.
        - Steps to compile and run the Java application.
        - A brief description of each functionality implemented in the application.


    
Good luck, and have fun building your Smart Kitchen Management System!


### How to set up the PostgreSQL database and create the required table

1. **Database Setup:**
    - Type 'sudo -u postgres psql' on terminal on my laptop
    - Create a new database named `smart_kitchen` using the following command:
        
        CREATE DATABASE smart_kitchen;
        
    - Connect to the `smart_kitchen` database using the following command:
        
        \c smart_kitchen;
   
    - Go to intellij and open database tab  -> select PostgreSQL
   
   - Add the database name, username and password and test the connection.
   
   - Open project structure and add the PostgreSQL driver(jarfile) to the project.
        
   - Inside the `smart_kitchen` database, create a table named `appliances` :
       
       CREATE TABLE appliances (
           id SERIAL PRIMARY KEY,
           name TEXT,
           type TEXT,
           status TEXT,
           usage_time INTEGER
       );
    
