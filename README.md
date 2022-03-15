# Testing Training

This repository is built into 4 different modules that you can work through however your want.
If you completely make your way through it, you will gain knowledge about testing in general and different frameworks that are commonly used in combination with tests.

The modules are generally based on Java 11 (download [here](https://developers.redhat.com/products/openjdk/download)) and Maven 3.6.3 (download [here](https://archive.apache.org/dist/maven/maven-3/))

## Different types of tests -> [link](1-types-of-tests)

In this module you will gain a fundamental understanding of tests in general - how/when/where/why/... to use them.
Topics that will be covered are among others the following:

- Testing pyramid - differences between Unit/Integration/E2E-Tests
- GUI testing
- Load testing
- ...

## Intro to Test-Driven-Development (TDD) -> [link](2-intro-to-tdd)

In this module you will get a glance upon a popular software development approach, which is known by the abbreviated name TDD.

Your goal is to make the failing tests in an example work again. You will be guided along by markdown files and JavaDoc comments.

## Integration tests -> [link](3-integration-tests)

Here you will get a quick glance over some of the most used integration testing libraries that are used in our projects.

These include:

- DBUnit
- JerseyTest
- WarpUnit (TBD)

For each library, you can read up on a little introduction and after that there is a small project with an example and guided tests that you can write yourself to get a better feeling for the frameworks.

## Mocking -> [link](4-mocking)

While testing there sometimes are areas of your class that you want to leave out of your tests. For that reason there exists a method called "mocking".

In this module, you will learn to handle one of the most well-known testing libraries overall called "Mockito" and write some sample tests with it.

## Useful Links

<!-- prettier-ignore -->
Name | Link | Description
---- | ---- | ----
JavaPoint | <https://www.javatpoint.com/software-testing-tutorial> | is a great resource for general information about testing (look at the menu on the left to choose a topic you are interested in)
GitHub | <https://github.com>  | a good idea if you need some help with some framework, is to search for it on GitHub - there are tons of user-created tutorials and trainings and most of the time the official repository (or at least a clone of it) is hosted there too
