package mouse.univ.productapplication.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Failing {
    @Value("${FAIL_TEST:no}")
    private String val;
    public boolean shouldFail() {
        if (val == null || val.isEmpty()) {
            return false;
        }
        return (val.equalsIgnoreCase("yes"));
    }
}
