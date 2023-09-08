# second-maven-project

This repository demonstrates the creation of a multi-module web application with three main modules:

1. **Data Model:** Contains data-related classes and structures.
2. **Business Logic:** Implements the core application logic.
3. **Presentation:** Manages the user interface and presentation layer.

### Setting up Tomcat

1. Configure Tomcat 10 through IntelliJ IDEA or by adding a configuration to the Maven plugin.

2. Ensure that Tomcat is properly set up, as it's required to run the web application.

### Parent POM Configuration

In this project, we have adopted a modular approach for managing dependencies and plugins using a parent POM (Project Object Model).

1. **dependencyManagement Section:**

   - The `dependencyManagement` section in the parent POM centralizes the version management of project dependencies.

2. **pluginManagement Section:**

   - The `pluginManagement` section in the parent POM centralizes the configuration of Maven plugins.

## JSON-Based Database Module

1. **Database Structure:**

   - The database module includes a JSON-based database containing at least a list of users.

2. **Initialization:**

   - Upon launching the application, test data is generated and written to JSON files in the database. This initializes the database with sample data.

3. **Data Manipulation:**

   - During the application's operation, the data in the JSON-based database is read and modified as needed. This includes serializing data to JSON whenever there are changes in the data model. The primary data model in this project is the `User` class.

## Web Module with API

The web module includes an API that allows interaction with the JSON-based database. It provides the following endpoints:

1. **Get a List of All Users:**

   - To retrieve a list of all users, send a GET request to the appropriate endpoint.

2. **Return User Information by ID:**

   - To get information about a specific user based on their ID, send a GET request with the user's ID as a parameter.

3. **Change User's Name by ID:**

   - To update a user's name based on their ID, send a PUT request with the user's ID as a parameter and provide the new name in the request body.

Feel free to explore and adapt this project for your specific needs. Enjoy working with JSON-based databases and web APIs!

You can find detailed instructions and code explanations within the project files.

