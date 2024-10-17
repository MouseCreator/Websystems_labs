package mouse.univ.productapp.controller;

import lombok.RequiredArgsConstructor;
import mouse.univ.productapp.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    @GetMapping
    public String getProduct() {
        return weatherService.callAPI();
    }

    @GetMapping("/wait")
    public void waiting() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted", e);
        }
    }
}
