# ShoppingGO

A fully functional e-commerce platform developed using **Spring Boot** for the backend and **JSP** for the frontend. This project showcases the implementation of core e-commerce features such as product management and user authentication.

## Screenshots 

    ![WhatsApp Image 2024-11-14 at 01 44 42_6e57a825](https://github.com/user-attachments/assets/932e2046-0028-4660-a5e6-e2d45e69c18e)
    ![WhatsApp Image 2024-11-14 at 01 48 32_0a71f4d5](https://github.com/user-attachments/assets/e7a84fb3-050c-4d3c-93b0-2ea9c0fbf939)
    ![WhatsApp Image 2024-11-14 at 01 49 12_8c6a172c](https://github.com/user-attachments/assets/73c57296-f7b5-4d2a-8623-20df7a26cced)
    

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
   ```bash
   git clone https://github.com/your-username/ecommerce-backend.git
2. Configure application.properties with your PostgreSQL credentials:
   ``` spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
3. Build the project using Maven:
   ``` mvn clean install
   mvn clean install
4. Run the application
   ``` mvn spring-boot:run
   mvn spring-boot:run
## Acknowledgments
 frontend code : https://github.com/navinreddy20/ecom-frontend-5
