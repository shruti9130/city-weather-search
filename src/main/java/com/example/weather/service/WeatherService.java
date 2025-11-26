package com.example.weather.service;

import com.example.weather.model.WeatherApiResponse;
import com.example.weather.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final CacheService cacheService = new CacheService();
    private final String API_KEY = "65f610def7a9d18ccc7ec8cd2cb14a36";

    public WeatherResponse getWeather(String city) {
        // Check cache first
        WeatherResponse cached = cacheService.get(city);
        if(cached != null) return cached;

        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city + "&appid=" + API_KEY + "&units=metric";

        WeatherApiResponse apiResponse = restTemplate.getForObject(url, WeatherApiResponse.class);
        if(apiResponse == null) throw new RuntimeException("Error fetching weather");

        WeatherResponse response = new WeatherResponse();
        response.setCity(apiResponse.getName());
        response.setDescription(apiResponse.getWeather()[0].getDescription());
        response.setTemperature(apiResponse.getMain().getTemp());
        response.setHumidity(apiResponse.getMain().getHumidity());
        response.setPressure(apiResponse.getMain().getPressure());
        response.setWindSpeed(apiResponse.getWind().getSpeed());
        response.setIcon(apiResponse.getWeather()[0].getIcon());

        cacheService.put(city, response); // store in cache
        return response;
    }
}
