# Integration tests

## Basics

Integration testing (short: IT) is the phase where multiple components are combined and tested as a group.
When putting it in general order, it occurs before validation testing and after unit testing.

There are different approaches for ITs

**Big Bang**
...is a version where most/all of the developed modules are coupled together and tested as a whole, which might save a lot of time if done right.

**Bottom-up**
...means that first the lower level components are tested, then the higher level ones and finally they are integration tested. This approach uses stubs to supplement the lower sub-modules during the testing of the higher level components.

**Top-down**
...is the opposite of Bottom-up. It means that first the higher level components are tested, then the lower level ones and after that they undergo integration testing. This method uses test drivers, mainly to pass the required data to the lower level modules.

**Sandwich or Hybrid**
...combines Top-down and Bottom-up.

## Frameworks

For integration testing there exist multiple frameworks, which can be used to speed up development processes and/or test a broader spec of your application instead of mocking it away (for example the database).

### DB-Unit -> [link](dbunit)

DBUnit is a framework that is used to reset a database to a known state between tests.
It has the ability to import and export from and to XML datasets.
You can also use it to compare parts of your database to an expected XML dataset.

### Jersey-Test -> [link](jersey)

Jersey-Test is a framework made for testing rest services.
You can simply call an url like you would from Postman (or similar) and then assert the results.

### Warp-Unit

```java
// TBD...
```
