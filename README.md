# Simple Contact Manager API

This project is a RESTful API for a simple contact management system.
It allows users to perform standard CRUD (Create, Read, Update, Delete) operations on a list of contacts.
The application is built with Java and the Spring Boot framework, using Spring Data JPA for data persistence in a PostgreSQL database.

## 🚀 Features

* **Create:** Add new contacts with a name, email, and phone number.
* **Read:**
    * Retrieve a list of all contacts.
    * Fetch a single contact by its unique ID.
* **Update:** Modify an existing contact's information.
* **Delete:** Remove a contact by its ID.

## ⚙️ Technologies Used

* **Java 21+**
* **Spring Boot 3.5.4**
* **Spring Data JPA**
* **PostgreSQL**
* **Maven**

## 🏁 Getting Started

### Prerequisites

* **Java Development Kit (JDK) 21**
* **Maven**
* **PostgreSQL** installed and running on your system.

### Installation

1.  **Clone the repository:**

    ```bash
    git clone [https://github.com/](https://github.com/)[your-username]/simple-contact-manager.git
    cd simple-contact-manager
    ```

2.  **Configure the database:**
    * Create a new PostgreSQL database (e.g., `contact_manager_db`).
    * Update the database connection properties in `src/main/resources/application.properties` with your credentials.

    ```properties
    # Database Configuration
    spring.datasource.url=jdbc:postgresql://localhost:5432/contact_manager_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.datasource.driver-class-name=org.postgresql.Driver

    # JPA Properties
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
    *(Note: We will configure this file in our next step.)*

3.  **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

    The application will start on `http://localhost:8080`.

## 📖 API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/contacts` | Retrieves a list of all contacts. |
| `GET` | `/api/contacts/{id}` | Retrieves a single contact by its ID. |
| `POST` | `/api/contacts` | Creates a new contact. Expects a JSON payload. |
| `PUT` | `/api/contacts/{id}` | Updates an existing contact. |
| `DELETE` | `/api/contacts/{id}` | Deletes a contact by its ID. |

## 🤝 Contributing

Contributions are welcome! Please feel free to open an issue or submit a pull request.
