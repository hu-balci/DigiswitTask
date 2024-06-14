`What are some best practices you follow for maintaining your
automation suite? How do you ensure your tests are reliable and
maintainable?`

Here are some simple points that help my tests reliable and easy to maintain.

I am using Page Object Model(POM) design pattern and Cucumber framework

Keep It Easy to Understand:
Use clear and descriptive names for methods and variables to make the code easy to understand.
Also using gherkin language makes my tests more clear to understand

Use Clear Names for pages
Use descriptive names for page objects and elements to make it easy to understand.

Find Elements Correctly:
Use reliable methods to find the elements on the page.

Keep It Simple:
Each page java class handles a single page for corresponding webpage or section to keep the code organized.

Hide Details:
Pages hide the details of interacting with the page, making the test code easier to read(abstract Base page)

Make It Reusable:
Objects, methods and elements are reusable across different tests to reduce duplicated code.
Also use reusable strings on feature files which makes step definitions more simple

Use configuration properties file:
Allows me to save all necessary data on it( url, environment, browser etc.) Also, it is easy to update 



`Can you describe your approach to developing a test automation
strategy? How do you balance between manual and automated
testing?`

Test Automation Strategy 
       * Understand the application
       * Analyze user story
       * Prioritize test cases
       * Define core functionalities of application
       * Perform manual test in the first place

Balance between manual and automation
       * Use manual testing for critical areas where automation may not work well.
              1. when doing exploratory testing to see end user experience on the web application
              2. initial development stage of a web application 
              3. where I need to provide more accurate feedback on the visual layer
              4. for test scenarios that have a short life cycle(not too much time-consuming) 
              5. before every automation tasks
       * Use automation for repetitive tasks that are easy to automate
              1.Unit testing(mostly done by developers)
              2.End to end testing(repetitive and time-consuming tests)
              3.Regression testing(after each deployment)


**`How do you ensure your automated tests provide sufficient coverage?
What strategies do you use to identify gaps in test coverage?`**

1. Understand the application well to identify gaps effectively
2. identify critical functions of application to ensure automate them
3. find out repetitive tasks for time saving 
4. Exploratory testing to cover unseen issues
5. Manual testing for identify gaps in test cases
6. Walkthrough on the tests with qa colleagues to have diverse perspective
7. peer reviews sessions for test scripts with qa lead to improve code quality


`● **Can you explain the Test Pyramid and its significance in test
automation?**`
3:end to end tests
2:integration testing
1:unit testing

The Test Automation Pyramid is a widely recognized software testing strategy that emphasizes distributing different types of tests across multiple levels. Here’s how it works:

**Unit Tests: (At the base of the pyramid)**
These focus on individual components or functions within the code.
They’re fast, reliable, and help catch low-level bugs.
These been done by developers before send code to test environment

**Integration Tests: (in the middle of the pyramid)** 
These verify interactions between different components and modules.
They ensure different parts of the application work together correctly 
Integration tests help identify issues related to data flow, APIs, and communication.
Slower than unit tests

**End-to-End Tests:(at the top of pyramid)**
They test the application as a whole.
They provide valuable coverage of the application
They would be slower and more time-consuming


**Test Automation Pyramid helps teams:**

1. Catch bugs early in the development cycle
2. Reduce the time required to identify and fix issues
3. Reduce costs of maintenance
4. Maintain a fast and reliable test suite
5. Ensure high-quality software is delivered consistently

        