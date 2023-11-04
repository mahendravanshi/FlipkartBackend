# FlipkartBackend
An online shopping platform enabling users to manage products, categories, and orders. Users can create orders, add products, update order details, and access their order history.



# Online Shopping Platform - Spring Boot Application

## Description
This comprehensive Spring Boot application is designed to manage an online shopping platform similar to Flipkart. The application incorporates essential entities, such as Products, Categories, Users, and Orders, and provides various operations to facilitate online shopping.

## Features

### User Level APIs
- **Register User**: POST /users - Register a new user.
- **User Authentication**: POST /auth/login - Authenticate a user and return JWT.
- **Create Order**: POST /orders/{userId} - Allow a user to create an order.
- **Add Product to Order**: PUT /orders/{orderId}/products - Allow a user to add a product to an order.
- **Update Order Details**: PUT /orders/{orderId} - Allow a user to update the order details (e.g., delivery date, quantity of products).
- **Fetch Order History**: GET /users/{userId}/orders - Fetch a user's order history.
- **Recommend Products**: GET /users/{userId}/recommended-products - Recommend products to a user based on their order history.

### Admin Level APIs
- **Add Products**: POST /products - Add new products.
- **Add Categories**: POST /categories - Add new categories.
- **Add Admin User**: POST /users/admin - Add new users (admin).
- **Delete Order (Admin)**: DELETE /orders/{orderId}/admin - Delete an order (admin).
- **Fetch Users (Admin)**: GET /users/admin - Fetch all users (admin).
- **Fetch Products (Admin)**: GET /products/admin - Fetch all products (admin).
- **Fetch Categories (Admin)**: GET /categories/admin - Fetch all categories (admin).

### Implementation Points
- Creating tables and implementing relationships among tables.
- Entity classes: Product, Category, User, Orders.
- Exception handling and data validation.

### Additional Features
- Pagination and sorting for GET APIs to improve data retrieval efficiency.
- Custom exception handling and appropriate HTTP status codes for error responses.
- Input validation on the backend to ensure data integrity.

## Getting Started
To run the application, you will need to configure your Spring Boot project with Swagger and JWT dependencies. See the provided resources section for configuration details.

## Resources
- [Swagger](https://swagger.io/): API documentation and testing.




