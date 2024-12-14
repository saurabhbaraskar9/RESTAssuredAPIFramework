# RESTAssuredAPIFramework

# REST Assured Framework for Mock Google Maps API

## Project Overview

This project is a REST Assured framework built to test CRUD operations of the Mock Google Maps API. It allows users to test operations such as adding, updating, deleting, and fetching places via the API.

## Features

- **Modular Design**: Well-organized structure using BDD Cucumber for behavior-driven testing.
- **Reusability**: Smart logging mechanism and data-driven approach to handle test data.
- **Extensive Reporting**: Integrated with **Extent Reports** for detailed test execution reports.
- **Logging**: Custom logging mechanism to capture the flow of test execution for debugging and traceability.
- **BDD Cucumber**: Enables writing tests in plain English using Gherkin syntax, making them easy to understand and maintain.

## Technologies Used

- **Java**: Programming language used for implementing the tests.
- **REST Assured**: API testing framework used for making HTTP requests and validating responses.
- **Maven**: Build tool to manage dependencies and project lifecycle.
- **BDD Cucumber**: Behavior-driven development framework for writing and executing Gherkin feature files.
- **Gherkin**: Syntax used for writing test scenarios in a human-readable format.

## Setup Instructions

### Prerequisites

- **Java 8** or above.
- **Maven 3.x** or above.
- IDE (IntelliJ IDEA, Eclipse, etc.) for code execution.
- Ensure that **Mock Google Maps API** is running or accessible for testing.

### Steps to Clone, Build, and Run the Project

1. Clone the repository:
    ```bash
    git clone https://github.com/saurabhbaraskar9/RESTAssuredAPIFramework.git
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

4. Run the tests:
    - Execute the tests by running the **TestRunner.java** class located under `src/test/cucumber/Options`.

## Usage

1. Tests are written using **BDD Cucumber**. To run the tests, execute the `TestRunner.java` class.
2. Example test case is written in **feature** files located under `src/test/features`.
3. Step definitions for the feature files are implemented in `src/test/stepDefinitions`.

## Folder Structure

Here’s a breakdown of the folder structure:

- **src/main**: Contains POJO classes used to serialize and deserialize JSON payloads.
- **src/test/features**: Contains **feature** files written in Gherkin format.
- **src/test/stepDefinitions**: Contains `StepDefinition.java` files that define the logic for executing the steps in the feature files.
- **src/test/cucumber/Options**: Contains the **TestRunner.java** file to run the tests.
- **src/test/resources**: Contains utility classes and reusable methods for test execution, `TestDataBuild.java` for handling test data, and `global.properties` for global configurations.
- **target**: Contains the compiled code, logs, and generated reports. Includes `gitignore`, `pom.xml`, and `logging.txt`.

## Documentation and Reports

- **Extent Reports**: Integrated into the framework to generate detailed test execution reports.
- The reports will be available in the `target` folder after running the tests.

## Contact

Feel free to reach out or explore the project:

- GitHub: [saurabhbaraskar9](https://github.com/saurabhbaraskar9)
  
---

> **Note**: This framework is intended for testing CRUD operations for the Mock Google Maps API.

