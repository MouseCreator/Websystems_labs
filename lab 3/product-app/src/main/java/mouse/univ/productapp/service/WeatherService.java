package mouse.univ.productapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    public String callAPI() {
        RestTemplate restTemplate = new RestTemplate();
        String URI = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m";
        return restTemplate.getForObject(URI, String.class);
    }

}