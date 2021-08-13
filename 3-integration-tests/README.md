# Basics

Integration testing (short: IT) is the phase where multiple components are combined and tested as a group. 
When putting it in general order, it occurs before validation testing and after unit testing.

There are different approaches for ITs

**Big Bang**

...is a version where most/all of the developed modules are coupled together and tested as a whole, which might save a lot of time if done right.

**Bottom-up**

...means that first the higher level components are tested, then the lower level ones and after that they undergo integration testing. This approach uses stubs to supplement the lower sub-modules during the testing of the higher level components.

**Top-down**

...is the opposite of Bottom-up. It means that first the lower level components are tested, then the higher level ones and finally they are integration tested. This method uses test drivers, mainly to pass the required data to the lower level modules.

**Sandwich**

...combines Top-down and Bottom-up.

# Frameworks

For integration testing there exist multiple frameworks, which can be used to speed up development processes and/or test a broader spec of your application instead of mocking it away (for example the database).

## DB-Unit

```java
// TODO
```

## Warp-Unit

```java
// TODO
```

## Jersey-Test

Jersey-Test is a framework made for testing rest services. 
You can simply call an url like you would call it from Postman (or similar) and then assert the results.

### Resources

You can find the website of the Jersey framework [here](https://eclipse-ee4j.github.io/jersey/) and their docs about the testing framework [here](https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/test-framework.html). 

Sadly their website and docs provide next to no value aside from some very basic information about the testing side. 
It does however give some information about different configurations (containers, properties, ...)

If you want to find out more, here are some nice resources:

- [Their own tests in their GitHub repository](https://github.com/eclipse-ee4j/jersey/tree/master/tests)
- [An example of DI with Hk2 on GitHub](https://github.com/m4nu56/jersey-hk2)

### Test

A simple test can look like the following (Source: [PingEndpointTest](jersey/src/test/java/com/gepardec/tdd/rest/PingEndpointTest.java)):

```java
@Test
public void testPing() {
    Response response = target("ping").request().get();
    String content = response.readEntity(String.class);

    // Assertions ...
}
```

In case you want to use Dependency Injection in your application, you have two Options:

- If you're running Java EE 7 or lower, you have to specifically bind your relevant resources
- If you're running Java EE 8 or higher, you can use a special [maven package named "jersey-cdi2-se"](#configuration)
### Setup & Deployment

Read the [SETUP.md](jersey/SETUP.md) inside the jersey maven module.

### Exercise

Go to the [UserEndpointTest](jersey/src/test/java/at/gepardec/trainings/tdd/jersey/rest/UserEndpointTest.java) and follow the instructions in the comments.