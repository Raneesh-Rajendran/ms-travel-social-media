# MS Travel Social Media

A microservices-based social media platform designed to connect travelers from around the world, enabling them to share experiences, interact, and discover travel content.

## 📋 Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Microservices](#microservices)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [API Gateway](#api-gateway)
- [Configuration Management](#configuration-management)
- [Monitoring and Tracing](#monitoring-and-tracing)
- [Contributing](#contributing)

## 🌟 Overview

MS Travel Social Media is a cloud-native, distributed application built using microservices architecture. The platform enables travelers to:
- Create and manage user profiles
- Share travel experiences and content
- Connect with fellow travelers worldwide
- Browse and interact with travel-related posts

## 🏗️ Architecture

The application follows a **Spring Cloud microservices architecture** with the following key patterns:

- **Service Discovery**: Netflix Eureka for dynamic service registration and discovery
- **API Gateway**: Netflix Zuul for routing, load balancing, and request aggregation
- **Distributed Tracing**: Spring Cloud Sleuth + Zipkin for request tracking across services
- **Centralized Configuration**: Spring Cloud Config Server for externalized configuration management
- **Client-Side Load Balancing**: Netflix Ribbon for distributing requests
- **Declarative HTTP Client**: OpenFeign for inter-service communication
- **Event-Driven Communication**: Spring Cloud Bus with AMQP for message distribution

### Architecture Diagram

```
                                    ┌─────────────────────┐
                                    │   React Frontend    │
                                    │   (Login & Feed)    │
                                    └──────────┬──────────┘
                                               │
                                               ▼
                                    ┌─────────────────────┐
                                    │   Zuul Gateway      │
                                    │   (Port: 8881)      │
                                    └──────────┬──────────┘
                                               │
                        ┌──────────────────────┼──────────────────────┐
                        │                      │                      │
                        ▼                      ▼                      ▼
            ┌──────────────────┐   ┌──────────────────┐   ┌──────────────────┐
            │ Authentication   │   │     Users        │   │     Content      │
            │  Service         │   │    Service       │   │    Service       │
            │  (PostgreSQL)    │   │  (PostgreSQL)    │   │                  │
            └────────┬─────────┘   └────────┬─────────┘   └────────┬─────────┘
                     │                      │                      │
                     └──────────────────────┼──────────────────────┘
                                            │
                     ┌──────────────────────┴──────────────────────┐
                     │                                              │
                     ▼                                              ▼
          ┌─────────────────────┐                        ┌─────────────────────┐
          │  Eureka Server      │                        │  Config Server      │
          │  (Port: 8880)       │                        │  (Port: 8882)       │
          └─────────────────────┘                        └─────────────────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │  Zipkin Server      │
          │  (Distributed       │
          │   Tracing)          │
          └─────────────────────┘
```

## 🔧 Microservices

### Core Services

| Service | Port | Description | Database |
|---------|------|-------------|----------|
| **ms-travel-social-naming-eureka** | 8880 | Service registry and discovery server using Netflix Eureka | N/A |
| **ms-travel-social-zuul-gateway** | 8881 | API Gateway for routing, filtering, and load balancing | N/A |
| **ms-travel-social-config-server** | 8882 | Centralized configuration management for all microservices | File-based |
| **ms-travel-social-authentication** | Dynamic | Handles user authentication, login, and session management | PostgreSQL |
| **ms-travel-social-users** | 8080 | Manages user profiles and user-related operations | PostgreSQL |
| **ms-travel-social-content** | Dynamic | Serves static content and travel-related posts | N/A |
| **ms-travel-social-zipkin-server** | 9411 | Distributed tracing and monitoring using Zipkin | In-memory |

### Frontend Applications

| Application | Description | Technology |
|-------------|-------------|------------|
| **ms-travel-social-login** | User authentication and login interface | React 18.3.1 + Vite 5.4.1 |
| **ms-travel-social-feed** | Main social feed for viewing and interacting with travel content | React 18.3.1 + Vite 5.4.1 |

## 💻 Technology Stack

### Backend
- **Framework**: Spring Boot 2.2.6/2.2.7
- **Language**: Java 8
- **Spring Cloud**: Hoxton.SR4
- **Database**: PostgreSQL
- **Service Discovery**: Netflix Eureka
- **API Gateway**: Netflix Zuul
- **Load Balancing**: Netflix Ribbon
- **HTTP Client**: OpenFeign
- **Configuration**: Spring Cloud Config
- **Tracing**: Spring Cloud Sleuth + Zipkin
- **Message Bus**: Spring Cloud Bus (AMQP)
- **Build Tool**: Maven

### Frontend
- **Framework**: React 18.3.1
- **Build Tool**: Vite 5.4.1
- **Module System**: ES Modules

## ⚙️ Prerequisites

Before running the application, ensure you have the following installed:

- **Java 8** or higher
- **Maven 3.6+**
- **Node.js 18+** and **npm**
- **PostgreSQL 12+**
- **Git**
- **RabbitMQ** (optional, for Spring Cloud Bus)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Raneesh-Rajendran/ms-travel-social-media.git
cd ms-travel-social-media
```

### 2. Setup PostgreSQL Databases

Create the required databases for the microservices:

```sql
CREATE DATABASE travel_social_auth;
CREATE DATABASE travel_social_users;
```

Update the database connection properties in the respective service configuration files.

### 3. Build All Microservices

```bash
# Build each Spring Boot microservice
cd ms-travel-social-naming-eureka && mvn clean install && cd ..
cd ms-travel-social-config-server && mvn clean install && cd ..
cd ms-travel-social-zuul-gateway && mvn clean install && cd ..
cd ms-travel-social-authentication && mvn clean install && cd ..
cd ms-travel-social-users && mvn clean install && cd ..
cd ms-travel-social-content && mvn clean install && cd ..
```

### 4. Setup Frontend Applications

```bash
# Setup Login Application
cd ui/ms-travel-social-login
npm install
cd ../..

# Setup Feed Application
cd ui/ms-travel-social-feed
npm install
cd ../..
```

## 🏃 Running the Application

**Important**: Start the services in the following order to ensure proper service registration and discovery:

### 1. Start Eureka Server (Service Discovery)

```bash
cd ms-travel-social-naming-eureka
mvn spring-boot:run
```

Access Eureka Dashboard at: `http://localhost:8880`

### 2. Start Config Server

```bash
cd ms-travel-social-config-server
mvn spring-boot:run
```

Config Server runs at: `http://localhost:8882`

### 3. Start Zipkin Server (Optional for Tracing)

```bash
cd ms-travel-social-zipkin-server
# Follow the instructions in the service directory
```

Zipkin UI available at: `http://localhost:9411`

### 4. Start API Gateway

```bash
cd ms-travel-social-zuul-gateway
mvn spring-boot:run
```

Gateway runs at: `http://localhost:8881`

### 5. Start Business Services

```bash
# Terminal 1 - Authentication Service
cd ms-travel-social-authentication
mvn spring-boot:run

# Terminal 2 - Users Service
cd ms-travel-social-users
mvn spring-boot:run

# Terminal 3 - Content Service
cd ms-travel-social-content
mvn spring-boot:run
```

### 6. Start Frontend Applications

```bash
# Terminal 1 - Login Application
cd ui/ms-travel-social-login
npm run dev

# Terminal 2 - Feed Application
cd ui/ms-travel-social-feed
npm run dev
```

## 📁 Project Structure

```
ms-travel-social-media/
├── ms-travel-social-authentication/    # Authentication microservice
├── ms-travel-social-config-repo/       # Configuration repository
├── ms-travel-social-config-server/     # Config server
├── ms-travel-social-content/           # Content management service
├── ms-travel-social-naming-eureka/     # Eureka service registry
├── ms-travel-social-users/             # User management service
├── ms-travel-social-zipkin-server/     # Zipkin tracing server
├── ms-travel-social-zuul-gateway/      # API Gateway
├── ui/                                 # Frontend applications
│   ├── ms-travel-social-login/         # Login React app
│   └── ms-travel-social-feed/          # Feed React app
└── README.md
```

## 🌐 API Gateway

All client requests should go through the Zuul API Gateway (`http://localhost:8881`), which will:
- Route requests to appropriate microservices
- Perform load balancing
- Apply filters for cross-cutting concerns (authentication, logging, etc.)
- Aggregate responses when needed

### Gateway Routes

```
/auth/**        → Authentication Service
/users/**       → Users Service
/content/**     → Content Service
```

## ⚙️ Configuration Management

The application uses Spring Cloud Config Server for centralized configuration management:

- **Config Repository**: `ms-travel-social-config-repo/`
- **Config Server**: Runs on port 8882
- All microservices fetch their configuration from the Config Server on startup
- Configuration can be updated without rebuilding services

## 📊 Monitoring and Tracing

### Eureka Dashboard
Monitor service health and registration status:
```
http://localhost:8880
```

### Zipkin Tracing
Track distributed requests across microservices:
```
http://localhost:9411
```

Each request gets a unique trace ID that can be followed through all microservices involved in handling that request.

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Development Guidelines

- Follow the existing code style and conventions
- Write meaningful commit messages
- Update documentation when adding new features
- Ensure all tests pass before submitting PR
- Add tests for new functionality

## 📝 License

This project is part of a learning initiative for building microservices-based applications.

## 👥 Authors

- Raneesh Rajendran - [GitHub Profile](https://github.com/Raneesh-Rajendran)

## 📞 Support

For issues, questions, or contributions, please open an issue in the GitHub repository.

---

**Happy Coding! 🚀✈️**
