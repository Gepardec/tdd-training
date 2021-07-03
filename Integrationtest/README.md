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
### Configuration

You need to import the relevant dependencies for your project:

```xml
<!-- Core Library -->
<dependency>
    <groupId>org.glassfish.jersey.test-framework</groupId>
    <artifactId>jersey-test-framework-core</artifactId>
    <version>${jersey.version}</version>
    <scope>test</scope>
</dependency>

<!-- Testing Container -->
<dependency>
    <groupId>org.glassfish.jersey.test-framework.providers</groupId>
    <artifactId>jersey-test-framework-provider-grizzly2</artifactId>
    <version>${jersey.version}</version>
    <scope>test</scope>
</dependency>

<!-- Is needed in case the application uses Dependency Injection -->
<dependency>
    <groupId>org.glassfish.jersey.inject</groupId>
    <artifactId>jersey-hk2</artifactId>
    <version>${jersey.version}</version>
    <scope>test</scope>
</dependency>

<!-- To parse the JSON in the response -->
<dependency>
    <groupId>org.glassfish.jersey.media</groupId>
    <artifactId>jersey-media-json-jackson</artifactId>
    <version>${jersey.version}</version>
    <scope>test</scope>
</dependency>
```

In case your Project is running on `javaee-api` 8+, you can also use the following dependency which makes Dependency Injection much easier:

```xml
<!-- Is optional for Dependency Injection (Only Java EE 8) -->
<dependency>
    <groupId>org.glassfish.jersey.inject</groupId>
    <artifactId>jersey-cdi2-se</artifactId>
    <version>${jersey.version}</version>
    <scope>test</scope>
</dependency>
```

### Test

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

### Quick Overview

In case you want do deploy the project to a Wildfly server, you can use the following command:

```bash
docker container run -itd \
    -p 8080:8080 \
    -p 9990:9990 \
    --name wildfly \
    jboss/wildfly \
    /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 \
    && mvn clean install -DskipTests \
    && docker container cp $(pwd)/target/it.war wildfly:/opt/jboss/wildfly/standalone/deployments/it.war
```

You can then open your browser to visit the exposed paths from the url http://localhost:8080/it/rest. E.g. http://localhost:8080/it/rest/ping

To trigger a rebuild and redeploy, run the following command:

```bash
mvn clean install -DskipTests \
    && docker container cp $(pwd)/target/it.war wildfly:/opt/jboss/wildfly/standalone/deployments/it.war \
    && docker container exec wildfly touch /opt/jboss/wildfly/standalone/deployments/it.war.dodeploy
```

