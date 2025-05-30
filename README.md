
# AI-Powered Credit Scoring System

This project implements an **AI-powered credit scoring system** using **Spring Boot**, **Flask**, **PostgreSQL**, **RabbitMQ**, and **NGINX**. It predicts credit scores based on user details, stores user information in a PostgreSQL database, and sends email notifications to the admin when a new user is registered.

## Architecture Overview

The system is built with a **microservice architecture** where each service is independently scalable. The following key components are included:

1. **User-Service**: Handles user CRUD operations, predicts the credit score using a Flask API, and stores the user data in a PostgreSQL database.
2. **Flask API**: Hosts the XGBoost model for credit score prediction based on the user data provided by User-Service.
3. **PostgreSQL**: A relational database to store user information and predicted credit scores.
4. **RabbitMQ**: A message queue to decouple services and send notifications when a user is added to the system.
5. **Email-Service**: Sends email notifications to the admin when a new user is registered.
6. **NGINX**: A reverse proxy and load balancer to distribute traffic across multiple instances of User-Service and Flask API.

## Key Features

- **Credit Score Prediction**: Using an XGBoost model hosted in a Flask API, the system predicts the credit score based on user details.
- **Load Balancing**: NGINX is used to load balance between multiple instances of the User-Service and Flask API.
- **Scalable Microservices**: Each service can be scaled independently based on demand.
- **Email Notifications**: Admin is notified via email when a new user registers in the system.
- **Real-time Workflow**: The process of predicting credit scores and sending email notifications is real-time and decoupled using RabbitMQ.

## Technologies Used

- **Backend**: 
  - **Spring Boot** (User-Service)
  - **Flask** (Credit Scoring API)
  - **PostgreSQL** (Database)
  - **RabbitMQ** (Message Queue)
  - **NGINX** (Load Balancer and Reverse Proxy)
- **Machine Learning**:
  - **XGBoost** (for credit score prediction)
- **Email**:
  - **SMTP Server** (for email notifications)

## Project Workflow

1. **User Registration**:
   - User details are sent to the `User-Service`.
   - `User-Service` calls the Flask API to predict the credit score.
   - The predicted credit score is stored in PostgreSQL along with user details.
   
2. **Email Notification**:
   - Upon successful user registration, a message is sent to RabbitMQ.
   - The `Email-Service` listens for the RabbitMQ message and sends an email notification to the admin.

## Getting Started

### Prerequisites

- Java 11 or higher
- Python 3.x
- Docker and Docker Compose
- PostgreSQL

### Setting up the Project Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/credit-scoring-system.git
   cd credit-scoring-system
   ```

2. **Running the Spring Boot User-Service**:
   - Navigate to the `user-service` directory and run the application:
     ```bash
     ./mvnw spring-boot:run
     ```

3. **Running the Flask Credit Scoring API**:
   - Navigate to the `flask-api` directory and install dependencies:
     ```bash
     pip install -r requirements.txt
     ```
   - Run the Flask application:
     ```bash
     python app.py
     ```

4. **Running RabbitMQ**:
   - Use Docker to run RabbitMQ:
     ```bash
     docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:management
     ```

5. **Running PostgreSQL**:
   - Set up PostgreSQL using Docker:
     ```bash
     docker run --name postgres -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres
     ```

6. **Running NGINX**:
   - Configure NGINX as a reverse proxy to balance load between user-service and Flask API.
   - Ensure that NGINX is set up to route traffic correctly to the services.

### Running the Project Using Docker Compose

To run all the services together using Docker Compose:

1. Ensure that you have a `docker-compose.yml` file set up for the project.

2. Run:
   ```bash
   docker-compose up --build
   ```

This will build and start all services (User-Service, Flask API, PostgreSQL, RabbitMQ, and NGINX) as containers.

### API Endpoints

- **User-Service**:
  - `POST /users`: Register a new user and predict their credit score.
  - `GET /users/{id}`: Get user details by user ID.
  
- **Flask API**:
  - `POST /predict`: Predict credit score based on user details.

- **Email-Service**:
  - Sends email notifications upon new user registration.

## Future Enhancements

- Implement **multi-region deployment** for better fault tolerance and lower latency.
- Add **real-time monitoring** using tools like Prometheus and Grafana.
- Integrate a **machine learning model retraining pipeline** to improve prediction accuracy over time.
- Introduce **caching** mechanisms (e.g., Redis) to improve performance.
- Implement **multi-factor authentication** for added security.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
#   F i n S i g h t  
 