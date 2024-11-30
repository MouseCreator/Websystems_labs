package mouse.uviv.productsapp.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class DefaultProfileInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();

        if (activeProfiles.length == 0) {
            environment.setActiveProfiles("default");
        }
        else if (activeProfiles[0].equals("${SPRING_PROFILES_ACTIVE}")) {
            environment.setActiveProfiles("default");
        }
        applicationContext.setEnvironment(environment);
    }
}
