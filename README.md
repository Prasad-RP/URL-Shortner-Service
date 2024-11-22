# URL-Shortener-Service

A Spring Boot-based application that allows users to shorten long URLs into compact, shareable links and manage them efficiently. The service uses MySQL as its database and is designed to be highly configurable and scalable.

---

## Features
- Shorten long URLs into compact short URLs.
- Retrieve the original URL from the short URL.

---

## Tech Stack
- **Backend Framework**: Spring Boot
- **Database**: MySQL
- **Language**: Java 17+
- **Build Tool**: Maven

---

## System Requirements
- Java 17 or higher
- Maven 3.8+
- MySQL 8.0+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

---

## Setup and Installation
**Clone the Repository and Run The Project**    
**Test the APIs**:
   - **POST API**: To persist the original URL and generate a short URL:
     - **Endpoint**: `http://localhost:5151/api/v1/url`
     - **Method**: `POST`
     - **Request Body**:
       ```json
       {
           "originalUrl": "https://www.shareresume.co/#/prasad-pansare"
       }
       ```
     - **Response**:
       ```json
        {
            "Data": {
                "urlId": 6,
                "originalUrl": "https://www.shareresume.co/#/prasad-pansare",
                "shortenedUrl": "554bf536",
                "createdDate": "2024-11-22T14:30:45.8552989",
                "expirationDate": null
            },
            "Success": true
        }
       ```

   - **GET API**: To resolve the short URL and auto-redirect to the original URL:
     - **Endpoint**: `http://localhost:5151/api/v1/url/{shortLink}`
     - **Method**: `GET`
     - Behavior: Redirects to the original URL.

---
  
