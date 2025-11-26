package com.example.weather.service;

import com.example.weather.model.WeatherResponse;
import java.util.concurrent.ConcurrentHashMap;

public class CacheService {

    private final ConcurrentHashMap<String, CacheEntry> cache = new ConcurrentHashMap<>();
    private final long EXPIRY_TIME_MS = 10 * 60 * 1000; // 10 minutes

    public WeatherResponse get(String city) {
        CacheEntry entry = cache.get(city.toLowerCase());
        if(entry != null && System.currentTimeMillis() - entry.timestamp < EXPIRY_TIME_MS) {
            return entry.data;
        } else {
            cache.remove(city.toLowerCase());
            return null;
        }
    }

    public void put(String city, WeatherResponse data) {
        cache.put(city.toLowerCase(), new CacheEntry(data));
    }

    private static class CacheEntry {
        WeatherResponse data;
        long timestamp;
        CacheEntry(WeatherResponse data) {
            this.data = data;
            this.timestamp = System.currentTimeMillis();
        }
    }
}
