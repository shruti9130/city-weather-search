# city-weather-search
City Weather Search coding challenge

This is a **City Weather Search** built using **Java Spring Boot**. Users can search for current weather by city name and view rich weather details from OpenWeatherMap API.

---

## 🔗 API Used

 OpenWeatherMap API (Current Weather Data)
  [https://openweathermap.org/current](https://openweathermap.org/current)

Example endpoint:


https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}&units=metric


**Attributes returned include:**

* City name
* Weather description
* Temperature
* Humidity
* Pressure
* Wind speed
* Sunrise & sunset times, etc.

## Features

* Search weather by **city name**.
* Displays:

  * Temperature (°C)
  * Weather description
  * Humidity (%)
  * Pressure (hPa)
  * Wind speed (m/s)
  * Other interesting attributes from the API.
* Responsive and professional UI.
* Caching implemented to improve performance for repeated requests:

  * Cache expiry: 10 minutes
  * Max cache entries: 50
* Handles invalid city names and network errors gracefully.



## 🌐 Backend (Java Spring Boot)

* Exposes a REST API endpoint:


GET /api/v1/weather/{city}


* Fetches data from OpenWeatherMap API.
* Returns structured JSON response for frontend consumption.
* Implements caching for performance and efficiency.



## 🖥️ Frontend

* `weather.html` in `src/main/resources/static/`
* Fetches weather data from backend API and renders it dynamically.
* Modern UI design with loader, error messages, and last searched city remembered.
* Input box and Enter key support for search.


## How to Run Locally

### Prerequisites

* Java 17+ installed
* Maven installed
* Internet connection (for API calls)

### Steps

1. Clone the repository:

bash
git clone https://github.com/shruti9130/city-weather-search.git


2. Navigate to project folder:

bash
cd weather-app


3. Build the project with Maven:

bash
mvn clean install


4. Run the Spring Boot application:

bash
mvn spring-boot:run


5. Open browser and visit:

http://localhost:8080/weather.html


6. Enter a city name to see the current weather.

---

## 📌 Notes

* **REST API guidelines** followed.
* Code structured for **extensibility** and **maintainability**.
* Error handling and edge cases implemented.
* Responsive, professional **UI design**.
* Backend caching improves **performance** for repeated searches.

---

## 📂 GitHub Repository

* Public repository: [https://github.com/shruti9130/city-weather-search](https://github.com/shruti9130/city-weather-search)
