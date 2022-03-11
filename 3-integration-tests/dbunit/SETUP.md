# Setup

You need to import the relevant dependencies for your project:

```xml
<!-- Core Library -->
<dependency>
  <groupId>org.dbunit</groupId>
  <artifactId>dbunit</artifactId>
  <version>${dbunit.version}</version>
  <scope>test</scope>
</dependency>

<!-- Dependency for your database -->
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>${mysql.connector.version}</version>
</dependency>

<!-- Or: h2 in memory database -->
<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <version>${h2.version}</version>
  <scope>test</scope>
</dependency>
```
