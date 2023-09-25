package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testNumberInInterval {

    private MainHW mainHW;

    @BeforeEach
    public void beforeEach() {
        mainHW = new MainHW();
    }

    @Test
    public void testInInterval() {
        assertTrue(mainHW.numberInInterval(26));
    }

    @Test
    public void testNotInInterval() {
        assertFalse(mainHW.numberInInterval(0));
    }
}
