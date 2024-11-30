package mouse.uviv.productsapp.profiles;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProfileManager {
    private final Environment environment;
    public ProfileManager(Environment environment) {
        this.environment = environment;
    }
    public void getActiveProfiles() {
        for (String profileName : environment.getActiveProfiles()) {
            log.info("[PROFILE] Active profile - " + profileName);
        }
    }
}
