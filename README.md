# Ktor Hexagonal Template

This project is a template for building web applications using the Ktor framework with a hexagonal architecture. It is
written in Kotlin and uses Gradle for build and dependency management.

## Technologies Used

- **Kotlin**: A statically typed programming language for the JVM, Android, and the browser.
- **Ktor**: An asynchronous framework for creating microservices, web applications, and more.
- **Gradle**: An open-source build automation system that supports multi-language development.
- **Docker**: A platform to develop, ship, and run applications inside containers.

## Running the Application Locally

To run the application locally, you need to have Kotlin and Gradle installed on your machine. Follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Run the application using Gradle:

```bash
./gradlew run
```

The application will start and listen on port 8080.

## Running the Application in Docker

To run the application in Docker, you need to have Docker installed on your machine. Follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Build the Docker image:

```bash
docker build -t ktor-hexagonal-template .
```

4. Run the Docker container:

```bash
docker run -it -p 8080:8080 -e MONGO_CONNECTION_STRING=your_connection_string ktor-hexagonal-template
```

Replace `your_connection_string` with your actual MongoDB connection string. The application will start and listen on
port 8080, and the logs will be displayed in the terminal.

Please note that this application uses MongoDB as its database, so you need to provide a MongoDB connection string as an
environment variable when running the Docker container.

## Future Steps

In the future, I would like to enhance the project with the following features:

- **Testing**: unit tests and integration tests to ensure the reliability and stability of the application.
- **Security with JWT**: JSON Web Token (JWT) for authentication and authorization. This will ensure that
  only authenticated and authorized users can access certain endpoints of the application.

## References

This project is inspired by and references the following resources:

- [Arquitectura Hexagonal con Spring Boot - Parte 1](https://medium.com/@oliveraluis11/arquitectura-hexagonal-con-spring-boot-parte-1-57b797eca69c):
  This article provides a comprehensive guide on implementing hexagonal architecture in a Spring Boot application.
  Although our project uses Ktor instead of Spring Boot, the principles and concepts presented in the article are
  applicable to any technology stack.
- [Arquitectura Hexagonal con Spring Boot - Parte 2](https://medium.com/@oliveraluis11/arquitectura-hexagonal-con-spring-boot-parte-2-bf5371d80d20):
  The second part of the series on hexagonal architecture with Spring Boot.
- [Arquitectura Hexagonal con Spring Boot - Parte 3](https://medium.com/@oliveraluis11/arquitectura-hexagonal-con-spring-boot-parte-3-60b4c3f4eaf7):
  The third part of the series, which delves deeper into the implementation details.
- [Arquitectura Hexagonal con Spring Boot - Parte 4 (Final)](https://medium.com/@oliveraluis11/arquitectura-hexagonal-con-spring-boot-parte-4-final-6d48876bdce1):
  The final part of the series, which wraps up the discussion and provides a complete picture of the architecture.