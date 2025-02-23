# **Product Service - README**

## **Overview**
The **Product Service** is a microservice designed to manage product-related operations, such as creating, retrieving, updating, and deleting products. It is built using **Spring Boot** and integrates with **MongoDB** for data storage. This service is part of a larger microservices-based architecture and follows best practices for scalability, maintainability, and performance.

---

## **Features**
1. **Create a Product**:
   - Add a new product with details like name, description, and price.

2. **Retrieve Products**:
   - Fetch a list of all products or a specific product by its ID.

3. **Update a Product**:
   - Modify the details of an existing product.

4. **Delete a Product**:
   - Remove a product from the database.

5. **Data Validation**:
   - Ensures that product data is valid before saving it to the database.

6. **Integration with MongoDB**:
   - Uses MongoDB as the database to store product information.

7. **RESTful API**:
   - Exposes a RESTful API for interacting with the service.

---

## **Technologies Used**
- **Spring Boot**: Framework for building the microservice.
- **MongoDB**: NoSQL database for storing product data.
- **Lombok**: Library for reducing boilerplate code.
- **Maven**: Build automation and dependency management.
- **RESTful API**: For communication with other services or clients.
- **Swagger/OpenAPI**: API documentation (optional).

---

## **Prerequisites**
Before running the project, ensure you have the following installed:
1. **Java Development Kit (JDK) 17 or higher**.
2. **Maven** for building the project.
3. **MongoDB** installed and running locally or remotely.
4. **IDE** (e.g., IntelliJ IDEA, Eclipse) for development.

---

## **Setup and Installation**

### **1. Clone the Repository**
```bash
git clone https://github.com/your-username/product-service.git
cd product-service
```

### **2. Configure MongoDB**
- Ensure MongoDB is running on your local machine or a remote server.
- Update the MongoDB connection details in the `application.properties` file:
  ```properties
  spring.data.mongodb.uri=mongodb://localhost:27017/productdb
  ```

### **3. Build the Project**
Run the following command to build the project:
```bash
mvn clean install
```

### **4. Run the Application**
Start the application using Maven:
```bash
mvn spring-boot:run
```

Alternatively, you can run the `ProductServiceApplication` class directly from your IDE.

---

## **API Documentation**

### **Base URL**
```
http://localhost:8080/api/products
```

### **Endpoints**

#### **1. Create a Product**
- **URL**: `/`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99
  }
  ```
- **Response**:
  ```json
  {
    "id": "65f8c1e2f1b2c44d8f7e9a1d",
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99
  }
  ```

#### **2. Get All Products**
- **URL**: `/`
- **Method**: `GET`
- **Response**:
  ```json
  [
    {
      "id": "65f8c1e2f1b2c44d8f7e9a1d",
      "name": "Laptop",
      "description": "High-performance laptop",
      "price": 999.99
    }
  ]
  ```

#### **3. Get a Product by ID**
- **URL**: `/{id}`
- **Method**: `GET`
- **Response**:
  ```json
  {
    "id": "65f8c1e2f1b2c44d8f7e9a1d",
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99
  }
  ```

#### **4. Update a Product**
- **URL**: `/{id}`
- **Method**: `PUT`
- **Request Body**:
  ```json
  {
    "name": "Updated Laptop",
    "description": "Updated description",
    "price": 1099.99
  }
  ```
- **Response**:
  ```json
  {
    "id": "65f8c1e2f1b2c44d8f7e9a1d",
    "name": "Updated Laptop",
    "description": "Updated description",
    "price": 1099.99
  }
  ```

#### **5. Delete a Product**
- **URL**: `/{id}`
- **Method**: `DELETE`
- **Response**: HTTP Status `204 No Content`.

---

## **Project Structure**
```
product-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── de/namastenepal/microservice/product_service/
│   │   │       ├── controller/          # REST controllers
│   │   │       ├── model/               # Entity classes (e.g., Product)
│   │   │       ├── repository/          # MongoDB repositories
│   │   │       ├── service/             # Business logic
│   │   │       └── ProductServiceApplication.java # Main application class
│   │   └── resources/
│   │       └── application.properties   # Configuration file
│   └── test/                            # Unit and integration tests
├── pom.xml                              # Maven build file
└── README.md                            # Project documentation
```

---

## **Configuration**
### **1. MongoDB Configuration**
Update the `application.properties` file to configure MongoDB:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/productdb
```

### **2. Server Port**
By default, the application runs on port `8080`. You can change it in the `application.properties` file:
```properties
server.port=8081
```

---

## **Testing**
### **Unit Tests**
Run unit tests using the following command:
```bash
mvn test
```

### **Integration Tests**
Integration tests can be run using the `@SpringBootTest` annotation. Ensure MongoDB is running before executing integration tests.

---

## **Deployment**
### **1. Build the JAR File**
```bash
mvn clean package
```

### **2. Run the JAR File**
```bash
java -jar target/product-service-1.0.0.jar
```

### **3. Docker Deployment**
You can containerize the application using Docker. Create a `Dockerfile`:
```dockerfile
FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/product-service-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

Build and run the Docker image:
```bash
docker build -t product-service .
docker run -p 8080:8080 product-service
```

---

## **Contributing**
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Submit a pull request with a detailed description of your changes.

---

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## **Contact**
For any questions or feedback, please contact:
- **Name**: Your Name
- **Email**: your.email@example.com
- **GitHub**: [your-username](https://github.com/your-username)

---

## **Acknowledgments**
- **Spring Boot**: For providing a robust framework for building microservices.
- **MongoDB**: For offering a scalable NoSQL database solution.
- **Lombok**: For reducing boilerplate code and improving code readability.

---

Thank you for using the **Product Service**! 🚀
