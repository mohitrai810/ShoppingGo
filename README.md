# E-Commerce Website

A fully functional e-commerce platform developed using **Spring Boot** for the backend and **JSP** for the frontend. This project showcases the implementation of core e-commerce features such as product management and user authentication.

## Features

- **CRUD Operations**: 
  - Add, update, delete, and view products.
- **Database Integration**:
  - PostgreSQL for efficient and secure data storage and retrieval.
- **User Authentication**:
  - Login and registration functionality.
  - Users can register or log in directly from the homepage and are redirected to the main website upon successful authentication.

## Frontend

The project uses a pre-designed frontend form for user login and registration, adapted from [navinreddy20/ecom-frontend-5](https://github.com/navinreddy20/ecom-frontend-5).

## Technologies Used

- **Backend**: Spring Boot
- **Frontend**: JSP
- **Database**: PostgreSQL
- **Tools**: Eclipse, pgAdmin, Git

## How to Run

1. Clone the repository:
   
bash
   git clone https://github.com/your-username/ecommerce-backend.git
2. Configure application.properties with your PostgreSQL credentials:
 spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
3. Build the project using Maven:
   
mvn clean install
4. Run the application
mvn spring-boot:run    

## Acknowledgments
 frontend code : https://github.com/navinreddy20/ecom-frontend-5
