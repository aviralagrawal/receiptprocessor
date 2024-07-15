# Receipt Processor

A simple receipt processor application built with Spring Boot.

## Getting Started

These instructions will help you set up and run the project on your local machine.

### Prerequisites

- Java 21
- Docker
- Git

### Building and Running the Application

1. **Clone the repository:**

    ```sh
    git clone https://github.com/your-username/receiptprocessor.git
    cd receiptprocessor
    ```

2. **Build the project:**

    ```sh
    ./gradlew build
    ```

3. **Run the application:**

    ```sh
    ./gradlew bootRun
    ```

   The application will be available at `http://localhost:8080`.

### Using Docker

1. **Build the Docker image:**

    ```sh
    docker build -t receiptprocessor:latest .
    ```

2. **Run the Docker container:**

    ```sh
    docker run -p 8080:8080 receiptprocessor:latest
    ```

   The application will be available at `http://localhost:8080`.

### API Documentation

The API documentation is available via Swagger UI at `http://localhost:8080/swagger-ui.html`.


