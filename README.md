# Online Shop

A simple online shop web application built with Spring Boot. It allows users to browse, create, edit, and delete products through both a web interface and a REST API.

## Tech Stack

- **Java 17**
- **Spring Boot 3.4.4**
- **Spring Data JPA** - database access and ORM
- **Spring Web** - REST API and MVC controllers
- **Thymeleaf** - server-side HTML templating
- **MySQL** - relational database
- **Lombok** - reduces boilerplate code
- **Jakarta Validation** - input validation

## Prerequisites

- Java 17 or higher
- Maven
- MySQL server running locally

## Getting Started

1. **Clone the repository**

   ```
   git clone https://github.com/norenaboi/onlineshop -b interface
   cd onlineshop
   ```

2. **Configure the database**

   Open `src/main/resources/application.properties` and update the datasource credentials to match your local MySQL setup:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/onlineshop?createDatabaseIfNotExist=true
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   ```

3. **Run the application**

   ```
   ./mvnw spring-boot:run
   ```

   The application will start on `http://localhost:8081`.

## REST API Endpoints

All endpoints are prefixed with `/api/products`.

| Method | Endpoint              | Description                        |
|--------|-----------------------|------------------------------------|
| GET    | `/api/products`       | Retrieve all products              |
| GET    | `/api/products/{id}`  | Retrieve a product by ID           |
| POST   | `/api/products`       | Create a new product               |
| PUT    | `/api/products/{id}`  | Update an existing product         |
| DELETE | `/api/products/{id}`  | Delete a product                   |
| GET    | `/api/products/search?name={keyword}` | Search products by name |
| GET    | `/api/products/type/{type}` | Get products by category     |

## Project Structure

```
src/main/java/com/norenaboi/onlineshop/
  controller/
    ProductController.java      - Thymeleaf web interface controller
    ProductAPIController.java   - REST API controller
  dto/
    ProductDTO.java             - Data Transfer Object for products
  model/
    Product.java                - Product entity
  repository/
    ProductRepository.java      - JPA repository
  service/
    ProductService.java         - Business logic layer
```
