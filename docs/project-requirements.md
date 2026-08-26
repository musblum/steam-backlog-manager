# Steam Backlog Manager

## Goal

Build a full-stack application that allows Steam users to import, organize, and track their game library.

## Version 1

### Steam Integration

* Import owned games using a Steam ID
* Retrieve game information from the Steam Web API
* Store imported games in PostgreSQL
* Retrieve and display Steam game artwork

### Library Management

* View imported games in a library
* Search games by title
* Filter games by status
* Sort games by:

  * Title
  * Rating
  * Hours played
* Organize games using the following statuses:

  * Backlog
  * Playing
  * Completed
  * Dropped
  * Live Service

### Game Details

* View game information and playtime
* Rate games
* Add and update personal notes
* Change a game's status

### Statistics

* View total number of games
* View total hours played
* View the number of games in each status category

### Persistence

* Store game data in PostgreSQL
* Preserve ratings, statuses, and notes between application sessions

## Version 2

* User registration and authentication
* Login and logout
* Separate game libraries for each user
* Associate a Steam account with a user account
* User-specific statistics
* Protected API endpoints
* Cloud deployment

## Future Features

* Random game picker
* Friends
* Recommendations
* Public profiles
* Achievement tracking
* Additional library analytics
* Support for additional gaming platforms
* Expanded automated testing
* Responsive UI improvements
