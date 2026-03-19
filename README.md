# Project Tracker API 🚀

A foundational RESTful API built to track and manage personal software projects without distraction. This project was developed to practically apply core Backend engineering concepts using Java and Spring Boot.

## 🛠️ Tech Stack
* **Language:** Java
* **Framework:** Spring Boot (Spring Web)
* **Tools:** Lombok, Maven
* **Architecture:** MVC (Model-View-Controller)
* **Data Storage:** In-Memory List (for foundational practice)

## 💡 Key Engineering Concepts Applied
* **RESTful Architecture:** Implemented full CRUD operations following REST principles.
* **Dependency Injection (DI):** Utilized manual Constructor Injection (Best Practice) for the Service layer.
* **Data Processing:** Leveraged modern Java Stream API for querying and filtering data.
* **Clean Code:** Maintained strict separation of concerns using the MVC pattern.

## 📡 API Endpoints

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/v1/projects` | Retrieves a list of all projects. |
| `GET` | `/api/v1/projects?status={status}` | Retrieves projects filtered by status (e.g., `IN_PROGRESS`). |
| `POST` | `/api/v1/projects` | Creates and adds a new project to the tracker. |
| `PUT` | `/api/v1/projects/{id}` | Updates an existing project's details based on its ID. |
| `DELETE` | `/api/v1/projects/{id}` | Deletes a project from the tracker using its ID. |

## 🚀 How to Run Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/zaidalsardi/project-tracker-api.git
2. Open the project in your favorite IDE (e.g., IntelliJ IDEA).

3. Ensure you have Java and Maven installed.

4. Run the ProjectTrackerApiApplication.java main class.

5. The API will be accessible at http://localhost:8080.
 
📌 Example JSON Payload (For POST/PUT requests):

JSON:
{
    "id": 104,
    "title": "E-Commerce Backend",
    "techStack": "Java, Spring Boot, PostgreSQL",
    "status": "PLANNED"
}
