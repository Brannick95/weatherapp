package com.tts.weayherapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

// import lombok.AllArgsConstructor;
// import lombok.RequiredArgsConstructor;

@Service
public class weatherservice {

    @Value("${api_key}")
    private String apiKey;

    public response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" +
                zipCode + "&units=imperial&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, response.class);
        } catch (HttpClientErrorException ex) {
            response response = new response();
            response.setName("error");
            return response;
        }
    }
}