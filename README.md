 Shopping Cart - Microservices
This project implements a shopping cart system using a microservices architecture with Spring Boot, Docker, and PostgreSQL.

Quick Start (Docker Only)
You don't need to install Java or PostgreSQL. Just ensure Docker is running and follow these steps:

1. Clone the repository.

2. Run the system: From the project root, open a terminal and run: docker compose up --build

3. Verify: The system is ready when you see the logs Started OrderServiceApplication and Started ProductServiceApplication.

Technical Information
• Order Service: http://localhost:8080 (Order management and persistence).

• Product Service: http://localhost:8081 (Proxy to FakeStoreAPI).

• Database: PostgreSQL (Port 5432).

Testing with Postman
A ready-to-import collection is included in the root folder: Shopping_Cart_Challenge.postman_collection.json

Main Endpoints:

• GET /api/products: List products via proxy.

• POST /api/orders: Create an order (real persistence).

• GET /api/orders: List all saved orders.
