# Medly_Pharma_SPringBoot
A Pharma Store with 1500+ of Medicines and Drugs build in SpringBoot 
# Medly Pharma - Spring Boot Project

Medly Pharma is a web application built using Spring Boot for pharmaceutical management.

## Table of Contents
-[Preview](#preview)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Installation](#installation)
- [Configuration](#configuration)
- [Features](#features)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)
## Preview

https://github.com/moxhadeel571/Grocery_Booking_SpringBoot/assets/60618158/d547611c-e819-492f-93fa-5cfe1c189ccb


## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK)
- Gradle
- MongoDB (or any other database of your choice)

## Getting Started

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/medly-pharma.git](https://github.com/moxhadeel571/Medly_Pharma_SPringBoot.git
    cd medly-pharma
    ```

2. Build and run the project:

    ```bash
    ./gradlew bootRun
    ```

3. Access the application at `http://localhost:8080`.

### Configuration

## MongoDB Setup and Dataset Import

### Prerequisites

Before you proceed, ensure you have the following prerequisites:

- [MongoDB Compass](https://www.mongodb.com/try/download/compass)
- A running instance of MongoDB

### Connecting MongoDB Compass to Your Database

1. Open MongoDB Compass.

2. Click on "New Connection."

3. Enter the connection details (hostname, port, authentication if any) and click "Connect."

4. You should now be connected to your MongoDB database.

### Importing Dataset

1. In MongoDB Compass, select the database where you want to import the dataset.

2. Make sure you've configured your `application.properties` with the correct MongoDB connection details in your Spring Boot project.

3. Download the dataset provided in the GitHub repository [`dataset.json`](https://drive.google.com/file/d/1O0vXtrycJ3bgVCNXStS76tmUV9PQmZuA/view?usp=drive_link).

4. In MongoDB Compass, navigate to your selected database.

5. Click on "Collection."

6. Click on "Import Data."

7. Select the downloaded `dataset.json` file.

8. Map the dataset fields to your MongoDB collection fields.

9. Click "Start Import."

### Adding Initial Product

1. Run your Spring Boot application.

2. Register as an admin user to access the admin functionalities.

3. Add at least one product through the admin interface.

4. This product will serve as a reference for the dataset you imported.

### Note

Ensure your `application.properties` in the Spring Boot project contains the correct MongoDB connection details, including the database name.

Now, you have successfully connected MongoDB Compass to your database, imported the provided dataset, and added an initial product to your Spring Boot application. You can now use this dataset for testing and development.


## Features

- 15000+ medicine datasets of Indian Drug store
- Variety of Drugs of all kind
- Pageable medicine of 100's
- View it and buy it
- Online Payment which is in trail mode

## Project Structure

![image](https://github.com/moxhadeel571/Medly_Pharma_SPringBoot/assets/60618158/93611492-907b-4a85-bdcd-7d5ca31ce373)

- All the data is in right path 

## Technologies Used

- Spring Boot
- Gradle
- MongoDB
- Spring Security
- Kaggle Dataset
- Intellij Idea
- MongoDb Compass

## Contributing

If you'd like to contribute to this project, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature: `git checkout -b feature-name`.
3. Commit your changes: `git commit -m 'Add some feature'`.
4. Push to your branch: `git push origin feature-name`.
5. Submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
