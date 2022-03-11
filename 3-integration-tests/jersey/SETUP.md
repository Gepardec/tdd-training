# Setup & Deployment

## Setup

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

## Deployment

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

You can then open your browser to visit the exposed paths from the url <http://localhost:8080/it/rest>. E.g. <http://localhost:8080/it/rest/ping>

To trigger a rebuild and redeploy, run the following command:

```bash
mvn clean install -DskipTests \
    && docker container cp $(pwd)/target/it.war wildfly:/opt/jboss/wildfly/standalone/deployments/it.war \
    && docker container exec wildfly touch /opt/jboss/wildfly/standalone/deployments/it.war.dodeploy
```
