# Movie Recommendation System with Content-Based Filtering

This project implements a movie recommendation system using a content-based filtering algorithm. Content-based filtering suggests movies to users based on the content features of the movies they have liked or interacted with.

## Overview

The recommendation system is built using Spring Boot for the backend, which provides a RESTful API for user interactions and recommendations. The content-based algorithm analyzes movie genres to make personalized suggestions.

## Content-Based Filtering Algorithm

The content-based filtering algorithm relies on the genres associated with each movie. It recommends movies to a user based on the genres of the movies they have previously interacted with. For example, if a user has liked or watched science fiction movies, the system will suggest other science fiction movies.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine
- Maven for managing dependencies

### Installation

1. Clone the repository:

```bash
git clone https://github.com/yourusername/movie-recommendation-system.git
```

2. Navigate to the project directory:

```bash
cd movie-recommendation-system
```

3. Build the project using Maven:

```bash
mvn clean install
```

4. Running the Application

```bash
mvn spring-boot:run
```
The application will start on `http://localhost:9090`

### Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework for building Java-based applications
- [Maven](https://maven.apache.org/) - Dependency management
