# Jersey

## Resources

You can find the website of the Jersey framework [here](https://eclipse-ee4j.github.io/jersey/) and their docs about the testing framework [here](https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/test-framework.html).

Sadly their website and docs provide next to no value aside from some very basic information about the testing side.
It does however give some information about different configurations (containers, properties, ...)

If you want to find out more, here are some nice resources:

- [Their own tests in their GitHub repository](https://github.com/eclipse-ee4j/jersey/tree/master/tests)
- [An example of DI with Hk2 on GitHub](https://github.com/m4nu56/jersey-hk2)

## Test

A simple test can look like the following (Source: [PingEndpointTest](src/test/java/com/gepardec/tdd/rest/PingEndpointTest.java)):

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

## Setup & Deployment

Read the [SETUP.md](SETUP.md) inside the jersey maven module.

## Exercise

Go to the [UserEndpointTest](src/test/java/at/gepardec/trainings/tdd/jersey/rest/UserEndpointTest.java) and follow the instructions in the comments.
