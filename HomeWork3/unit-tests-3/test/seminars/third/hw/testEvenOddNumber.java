package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.hw.MainHW;

import static org.junit.jupiter.api.Assertions.*;

public class testEvenOddNumber {
    private MainHW mainHW;
    @BeforeEach
    public void beforeEach() {
        mainHW = new MainHW();
    }

    @Test
    public void testEvenNumber() {
        assertTrue(mainHW.evenOddNumber(4));
    }

    @Test
    public void testOddNumber() {
        assertFalse(mainHW.evenOddNumber(5));
    }
}
