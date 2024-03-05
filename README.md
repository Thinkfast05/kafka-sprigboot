# Spring Boot Kafka Application

This repository showcases a Spring Boot application integrated with Kafka to publish information about individuals received through a REST API. The application validates and processes JSON objects representing people, publishing them to a Kafka topic for further consumption.

## Person JSON Object

The REST API endpoint accepts a JSON object in the following format:

```json
{
  "id": "uniqueIdentifier",
  "name": "PersonName",
  "age": PersonAge
}
```

- **id:** A unique identifier for the person.
- **name:** The person's name.
- **age:** The person's age as an integer.

## REST API Endpoint

Implemented a POST endpoint at `/api/person` that accepts the person JSON object. The application validates the JSON object to ensure all fields are present, and the age is a positive integer. Upon receiving a valid JSON object, it extracts the data and forwards it to a Kafka topic.

## Kafka Producer

The Kafka producer is configured to serialize the JSON data for transmission to a Kafka topic named `person-topic`. It ensures that the producer correctly handles serialization to preserve the JSON format within the Kafka message.

## Logging

The application logs the receipt of a valid person object and its publication to Kafka, including any relevant identifiers. This helps in tracking and understanding the flow of data within the application.

## Getting Started

1. Clone the repository to your local machine.
   ```bash
   git clone https://github.com/your-username/springboot-kafka-application.git
   ```

2. Configure Kafka properties in the `application.properties` file.

3. Build and run the Spring Boot application.
   ```bash
   ./mvnw spring-boot:run
   ```

4. Use a tool like `curl` or Postman to send POST requests to `http://localhost:8080/api/person` with valid JSON objects.

## Technologies Used

- Spring Boot
- Kafka
- JSON Serialization
- Logging

## Contributing

Contributions are welcome! Feel free to fork the repository, make your changes, and submit a pull request. Please follow the [code of conduct](CODE_OF_CONDUCT.md) and ensure that your contributions align with the project's goals.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code for personal or commercial purposes.

Enjoy working with Spring Boot and Kafka! If you have any questions or suggestions, don't hesitate to open an issue or reach out to the project maintainers.
