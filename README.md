# Digiswit Task

## Technologies and Concepts Used

The technologies and concepts implemented in the project include:

- Java (v17)
- Maven (4.0.0)
- Selenium
- Cucumber
- Page Object Model (POM)
- Gherkin language

It also involves core Object Oriented Programming (OOP) concepts including inheritance, polymorphism, and encapsulation.


## Dependencies

The following dependencies have been used in the project:


- selenium (4.18.1)
- cucumber-junit (4.8.1)
- cucumber-java  (4.8.1)
- bonigarcia   (5.8.0)
- junit assertions  (5.10.2)
- RestAssured library (4.3.3)


Also, there are two plugins included:

- Gherkin
- Cucumber for Java


## Project Structure

The project has several key components:

- **POM.xml:** This file includes all necessary project dependencies.
- **Configuration.properties:** This file is used to store core configuration data.
- **ConfigReader class:** This class is used to retrieve data from the `configuration.properties` file.
- **Driver class:** This class demonstrates encapsulation through the use of a private WebDriver object, `driver`.
  Each test run generates a new, unique driver (an instance of polymorphism), used specifically for that test.
  Upon completion, the test-specific driver is closed.
- **BasePage class:** This class contains reusable methods that can be used across all pages of the application.
  Pages classes extend the `BasePage` class to inherit these common methods.
- **CukesRunner class:** This class allows for running the scenarios using tags.
- **Features:** This directory holds the Cucumber feature files which is created by using gherkin language.
- **Pages:** This directory includes classes for each page of the application that has necessary locators and methods.
  Each page class extends `BasePage` class to inherit common methods of that class.
- **Step Definitions:** This directory contains the Cucumber step definition files which been build up by Java language and Junit assertions
- **Utilities:** This directory encapsulates utility classes as Driver and configReader which been used all over the project


## Usage

Clone the project to your local machine and run the automation tests using your preferred IDE.
The CukesRunner class is used to run the scenarios.
Also for each scenario there is a specific tag which makes possible to run API and UI tests separately.
Please make sure necessary technologies have been installed on your device (Java SDK, maven,) before launch the project
