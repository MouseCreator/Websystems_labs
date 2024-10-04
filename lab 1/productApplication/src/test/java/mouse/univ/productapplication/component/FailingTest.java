package mouse.univ.productapplication.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class FailingTest {
    private Failing failing;

    @BeforeEach
    void setUp() {
        failing = new Failing();
    }

    @Test
    void failTest() {
        if (failing.shouldFail()) {
            fail();
        }
    }
}
