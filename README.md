# Steam Backlog Manager

A full-stack web application for importing, organizing, and tracking a user's Steam game library.

Steam Backlog Manager allows users to import games directly from Steam, organize them by play status, rate games, save personal notes, search their library, and view statistics about their collection.

## Features

* Import owned games using a Steam ID
* Retrieve game data from the Steam Web API
* Organize games into:

    * Backlog
    * Playing
    * Completed
    * Dropped
    * Live Service
* Search games by title
* Filter games by status
* Rate games
* Add and update personal notes
* View playtime and game information
* Display Steam game artwork
* View library statistics, including total games, total hours played, and status breakdowns
* Persistent game data stored in PostgreSQL

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Web MVC
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Bean Validation
* Steam Web API

### Frontend

* React
* JavaScript
* React Router
* HTML
* CSS
* Vite

### Development Tools

* Git
* GitHub
* Postman
* IntelliJ IDEA

## Architecture

The backend follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

* **Controllers** expose REST API endpoints and handle HTTP requests.
* **Services** contain application and business logic.
* **Repositories** provide database access through Spring Data JPA.
* **DTOs** define the data sent between the frontend and backend.
* **Entities** represent persistent database records.

The React frontend communicates with the Spring Boot backend through REST APIs.

## Project Structure

```text
steam-backlog-manager/
├── backend/        # Spring Boot REST API
├── frontend/       # React frontend
├── docs/           # Project documentation
└── README.md
```

## API Overview

### Games

```text
GET    /api/games
GET    /api/games/{id}
POST   /api/games
PUT    /api/games/{id}
DELETE /api/games/{id}

GET    /api/games/search?title=
GET    /api/games/status?status=
GET    /api/games/rating
GET    /api/games/stats
```

### Steam Integration

```text
GET  /api/steam/games?steamId=
POST /api/steam/import?steamId=
```

## Running the Project Locally

### Prerequisites

Make sure you have installed:

* Java 17+
* PostgreSQL
* Node.js and npm
* Maven or the included Maven wrapper
* A Steam Web API key

### 1. Clone the repository

```bash
git clone https://github.com/musblum/steam-backlog-manager.git
cd steam-backlog-manager
```

### 2. Create the PostgreSQL database

```sql
CREATE DATABASE steam_backlog_manager;
```

Update the database configuration in:

```text
backend/src/main/resources/application.properties
```

with your PostgreSQL username and password.

### 3. Configure the Steam API key

Set your Steam Web API key as an environment variable:

```bash
export STEAM_API_KEY=your_api_key_here
```

### 4. Start the backend

```bash
cd backend
./mvnw spring-boot:run
```

The backend runs on:

```text
http://localhost:8080
```

### 5. Start the frontend

In another terminal:

```bash
cd frontend
npm install
npm run dev
```

The frontend runs on:

```text
http://localhost:5173
```

## What I Learned

This project was built to strengthen my understanding of full-stack software development, including:

* Designing REST APIs with Spring Boot
* Structuring applications using controller, service, repository, DTO, and entity layers
* Persisting relational data with PostgreSQL and JPA/Hibernate
* Integrating an external API
* Handling synchronization between external Steam data and locally stored user data
* Connecting a React frontend to a Java backend
* Managing application state and client-side routing
* Using Git branches and pull requests during feature development

## Future Improvements

* User accounts and authentication
* Cloud deployment
* Improved filtering and sorting
* Additional library analytics
* Expanded automated testing
* Responsive UI improvements
* Support for additional gaming platforms

## Author

**Salem Abdallah**

Computer Science / Software Development graduate based in New York.

GitHub: [musblum](https://github.com/musblum)
