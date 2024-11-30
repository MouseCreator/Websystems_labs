package mouse.uviv.productsapp.profiles;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ProfileManager {
    private final Environment environment;
    public ProfileManager(Environment environment) {
        this.environment = environment;
    }
    public void getActiveProfiles() {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("[PROFILE] Active profile - " + profileName);
        }
    }
}
