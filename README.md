# B2C Payment Service

A Spring Boot microservice for processing **Business-to-Consumer (B2C)** payments via mobile money platforms (like **M-Pesa**, **Airtel Money**) and sending **SMS notifications** to customers based on transaction outcomes.

---

## Features

- Exposes a REST API to initiate B2C payments
- Integrates with mobile money providers (via mock APIs for now)
- Sends SMS notifications on transaction success or failure
- OAuth2 authentication for securing APIs
- In-memory database (H2) for transaction logging
- Containerized using Docker
- Modular, scalable, and testable architecture
- Ready for production-level extension

---

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Security (OAuth2 Resource Server)
- Spring Data JPA
- H2 Database
- WebClient (Reactive HTTP client)
- Docker

---

## Project Structure

```plaintext
b2c-payment-service/
│
├── config/          # Security and application configuration
├── controller/      # REST API endpoints
├── service/         # Business logic (B2C and SMS handling)
├── dto/             # Data Transfer Objects
├── model/           # Database entities
├── repository/      # JPA Repositories
├── exception/       # Global exception handling
├── security/        # OAuth2 Resource Server config
├── resources/       # Properties and mock API files
└── Dockerfile       # Docker build instructions

Mock APIs and Testing with Postman
In this project, I have used Mockoon and Postman to simulate and test external API interactions during the B2C payment workflow.

Mockoon was used to create a mock server to simulate external service APIs such as the B2C Payment API. I configured a mock POST endpoint at http://localhost:8081/mock-b2c-payment that returns a predefined successful response. This allowed me to test the payment service without relying on a real external payment gateway.

Postman was used to manually send HTTP requests to the application's endpoints (e.g., http://localhost:8080/b2c/payment) to verify that the services are working as expected. Postman helped me quickly validate request/response structures and observe application behavior during success and error scenarios.

By using Mockoon and Postman, I was able to ensure the application behaves correctly when integrating with external services and to simulate both success and failure cases in a controlled environment.

