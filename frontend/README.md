# Steam Backlog Manager Frontend

Frontend for the Steam Backlog Manager application.

The interface is built with React and communicates with the Spring Boot backend to display and manage a user's imported Steam game library.

## Technologies

* React
* JavaScript
* React Router
* Vite
* CSS

## Features

* View imported Steam games
* Search games by title
* Filter games by status
* Sort games by title, rating, or hours played
* View detailed game information
* Update game status
* Rate games
* Add and edit personal notes
* View library statistics
* Display Steam game artwork with fallback handling for missing images

## Project Structure

The frontend source code is located in `src/` and is organized into:

* `components/` — reusable UI components
* `pages/` — application pages
* `App.jsx` — application routing and main layout
* `main.jsx` — React application entry point
* CSS files — application styling

## Running the Frontend Locally

Install dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

Vite will display the local development URL in the terminal.

The Spring Boot backend must also be running for API-dependent features to work.

## Available Scripts

```bash
npm run dev
```

Starts the Vite development server.

```bash
npm run build
```

Creates a production build.

```bash
npm run lint
```

Runs ESLint.

```bash
npm run preview
```

Runs a local preview of the production build.

## Backend

The backend for this project is located in the `backend/` directory of the main Steam Backlog Manager repository.

For complete project setup instructions and documentation, see the root `README.md`.
