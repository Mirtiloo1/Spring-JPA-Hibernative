# JpaHibernative - Recipe Management Application

## Description
JpaHibernative is a Spring Boot application that allows users to fetch recipes from a public API, save them to a local H2 database, and manage them via a command-line interface (CLI). The application integrates with a REST API to retrieve recipes and offers basic CRUD operations to manage the recipes locally.

## Features:
- Fetch recipes by ID from a public API (https://dummyjson.com/recipes).
- Save recipes to a local H2 database.
- List all saved recipes from the local database.
- Command-line interface for user interaction.

## Technologies Used:
- **Spring Boot** for application development.
- **Spring Data JPA** for database operations.
- **Hibernate** for ORM functionality.
- **H2 Database** for local storage.
- **RestTemplate** for interacting with the public API.
- **Maven** for project management.

## How It Works:
1. **Search for Recipes**: Users can fetch recipes from the API by providing the recipe ID. The details of the recipe are shown in the console.
2. **Save Recipes**: After fetching a recipe, users can choose to save it in the local database for later use.
3. **List Saved Recipes**: Users can view a list of all recipes saved in the database.
