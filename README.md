# AI Portrait Backend

This is the backend application for the AI Portrait project, built using Spring Boot. It provides APIs for generating AI-based portrait images and managing related operations. The backend is containerized with Docker for ease of deployment.

## Features

- REST APIs for managing portrait requests.
- Multi-stage Dockerfile for efficient containerization.
- Configurable environment variables for different environments.
- Maven-based project structure.

## Tech Stack

- **Java (Spring Boot)**: Backend framework for handling APIs and business logic.
- **Docker**: For containerizing the application.
- **Maven**: Build and dependency management.
- **MongoDB/Oracle** *(Optional)*: Specify the database if needed.

## Getting Started

### Prerequisites

- Java 17+
- Docker & Docker Compose
- Maven 3.x
- An IDE of your choice (e.g., IntelliJ, Eclipse)

### Running the Application

1. **Clone the Repository**
   ```bash
   git clone https://github.com/adarshp14/ai-portrait-backend.git
   cd ai-portrait-backend
