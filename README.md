# Pedidos — Spring Boot Learning Project

A Java backend learning project exploring the foundations of REST APIs, persistence, authentication and common enterprise application integrations.

> **Project status:** Educational/legacy codebase. The documentation distinguishes declared dependencies from verified working features. This is not a production-ready reference implementation.

## Technology stack

Based on the repository's `pom.xml`:

- Java 8 and Spring Boot 2.0.2.RELEASE
- Spring Web and Spring Data JPA
- Spring Security and `jjwt` 0.7.0
- H2 and MySQL JDBC driver
- Spring Mail and Thymeleaf
- Maven and Spring Boot Maven Plugin

The presence of a dependency does **not** necessarily mean its related functionality is fully implemented. MongoDB, AWS S3 and Ionic are not declared in the inspected Maven configuration.

## Architecture and configuration

This is a Maven-packaged Spring Boot JAR application. The declared dependencies support HTTP endpoints, JPA persistence, security and mail integration. Review the Java classes to determine the exact controllers, service boundaries, authentication flow and available API endpoints.

Configuration files:

- `src/main/resources/application.properties` — activates the `test` profile by default.
- `src/main/resources/application-test.properties` — H2 file database at `jdbc:h2:file:~/test`, H2 console at `/h2-console`, and SMTP configuration placeholders.
- `src/main/resources/application-dev.properties` — MySQL at `localhost:3306/curso_spring` with username `root`; this profile sets `spring.jpa.hibernate.ddl-auto=create`.

**Caution:** The development profile's `ddl-auto=create` setting can recreate database tables. Use a disposable database and do not point this configuration at valuable data. Never commit real SMTP or database credentials.

## Run locally

Prerequisites: JDK 8 and Maven. For the `dev` profile, a local MySQL instance and a `curso_spring` database are also required.

```bash
git clone https://github.com/fefeutitan/pedidos.git
cd pedidos
mvn clean package
mvn spring-boot:run
```

The default `test` profile uses H2. To select the MySQL development profile explicitly:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

Application startup has **not** been verified as part of this documentation update. Depending on the code path, e-mail functionality may require additional SMTP settings. Do not assume the H2 console or application endpoints are suitable for public exposure.

## Tests

```bash
mvn test
```

This command invokes the Maven test phase; passing tests and coverage have not been independently verified.

## Maintenance notes

Spring Boot 2.0.2 and the JWT dependency are legacy versions. Before deploying or using this as a template for new applications, review dependency security, authentication configuration, database initialization and environment-specific secrets.

## About

A personal learning repository by [Fernando Ellery](https://github.com/fefeutitan). For professional experience, see [LinkedIn](https://www.linkedin.com/in/fernando-ellery-133a209/).
