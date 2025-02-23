package de.namastenepal.microservice.product_service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;
import org.hamcrest.Matchers;
import org.testcontainers.utility.DockerImageName;

/**
 * Integration Test for Product Service using Testcontainers and RestAssured.
 * - Uses Testcontainers to create a temporary MongoDB instance.
 * - Starts Spring Boot application on a random port.
 * - Sends API requests using RestAssured.
 */
@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Start app on random port
class ProductServiceApplicationTests {

	/**
	 * Start a MongoDB Testcontainer instance for database testing.
	 */
	@ServiceConnection
	static MongoDBContainer mongoDBContainer =
			new MongoDBContainer(DockerImageName.parse("mongo:latest").asCompatibleSubstituteFor("mongodb_container"));

	/**
	 * Injects the dynamic port where Spring Boot is running.
	 */
	@LocalServerPort
	private int port;

	/**
	 * Configure RestAssured before each test.
	 */
	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	/**
	 * Start MongoDB before tests.
	 */
	static {
		mongoDBContainer.start();
	}

	/**
	 * Test case: Creating a product via POST request.
	 * Fixes:
	 * - Uses `ContentType.JSON` instead of plain text.
	 * - Expects `application/json` in the response.
	 */
	@Test
	void shouldCreateProduct() {
		// JSON request body
		String requestBody = """
                {
                    "name": "iPhone 15",
                    "description": "iPhone 15 is a smartphone from Apple",
                    "price": 1000
                }
                """;

		// Perform POST request and validate response
		RestAssured.given()
				.contentType(ContentType.JSON) // Ensure request is JSON
				.body(requestBody)
				.when()
				.post("/api/products")
				.then()
				.assertThat()
				.statusCode(201) // Expect HTTP 201 Created
				.contentType(ContentType.JSON) // Expect response to be JSON
				.body("id", Matchers.notNullValue()) // Ensure ID exists
				.body("name", Matchers.equalTo("iPhone 15")) // Validate name
				.body("description", Matchers.equalTo("iPhone 15 is a smartphone from Apple")) // Validate description
				.body("price", Matchers.equalTo(1000)); // Validate price
	}
}
