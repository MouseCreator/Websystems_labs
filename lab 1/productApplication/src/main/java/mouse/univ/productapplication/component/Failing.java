package mouse.univ.productapplication.component;

import org.springframework.stereotype.Component;

@Component
public class Failing {
    private final String val = System.getenv("FAIL_TEST");
    public boolean shouldFail() {
        if (val == null || val.isEmpty()) {
            return false;
        }
        return (val.equalsIgnoreCase("yes"));
    }
}
