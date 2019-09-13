# Captial-assignment
a sample project to calculate the area of a given shapes

[![Build Status](https://api.travis-ci.com/HITimran/captial-assignment.svg?branch=master)](https://travis-ci.com/HITimran/captial-assignment)
[![Coverage Status](https://coveralls.io/repos/github/HITimran/captial-assignment/badge.svg)](https://coveralls.io/github/HITimran/captial-assignment)

### Overview
###### Task Descriptions:
 
Create a library (preferable using C#) which will be used by a third-party to calculate an area of different shapes using an array of integers as an input.

###### Requirements:
* Supported shapes: Circle (by radius), Triangle (by three sides)
* Should be easily expendable to support other shapes without breaking the existing code
* Should be covered with unit tests

###### Project Descriptions:

###### Background 
A project is created to calculate the area of different shapes , implemented shapes such as circle (using radius) and Triangle (using its 3 sides).
The design pattern followed in this project is *factory design pattern* which falls under creational pattern design strategy , in factory pattern , we refer to a newly created object using common interface, here we create an object without exposing it to the client
the creation logic.
It also promotes loose-coupling by eliminating the need to bind application-specific classes into the code. That means the code interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends that abstract class and that solves our problem for incorporating new shapes and calculating its area without breaking the existing code.
Junit4 is being used to write the unit test . 

###### Tech Spec
 1. Language : Java 1.8
 2. UnitTest : Junit4
 3. BuildFramework : Maven 3.3
 4. BuildTools : TravisCI
 5. CodeCoverage : Coveralls
 6. version control : GitHub
 7. Reporting : Jacoco , Coveralls 

### Project Setup

###### Requirements
This project does requires
* JAVA 1.8
* MAVEN
* GIT CLI
* TextEditor/IDE

The project set up is pretty straight forward , please follow the below steps:

Assuming user is familiar with usage and has software such as git CLI ,java 8 and maven and it environment setup ,
 - [x] clone project using git cli in your local machine.
 - [x] on root directory of the project , run the command *mvn clean install* in cmd.
 - [x] after the successful build a ready to use library *[.jar]* is generated in the target directory,which can further be used as a 3rd party library.
 - [x] if required , you can also check out the Jacoco *report* generated in the home directory \report\testCoverage-reports\index.html

### BuildTools And Reporting
- With each new feature/merge in git repository the build gets trigger automatically on Travis CI [Click Me for Build Info.](https://travis-ci.com/HITimran/captial-assignment) 
- The coverage reports can be observed in coverall [Click me for Coverage Report](https://coveralls.io/github/HITimran/captial-assignment)
- The offline Jacoco *reports* can also be generated to show the unit test coverage reports
