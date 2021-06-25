# Integrationtest

## DB-Unit



## Jersey-Test

Jersey-Test is a framework made for testing rest services. 
You can simply call an url like you would call it from Postman (or similar) and then assert the results.

Website: https://eclipse-ee4j.github.io/jersey/

### Quick Overview

To have a closeup view on how it works, check out the example test [PingEndpointTest](src/test/java/com/gepardec/tdd/rest/PingEndpointTest.java)

In case you want do deploy the project to a wildfly server, you can use the following command:

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

### Exercises

