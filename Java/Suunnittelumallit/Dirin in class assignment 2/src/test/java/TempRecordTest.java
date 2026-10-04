import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TempRecordTest {
    private static final double DELTA = 0.001;

    @Test
    void testConstructorAndGetters() {
        TempRecord record = new TempRecord(1, 100.0, 1, 212.0, 2);

        assertEquals(1, record.getId());
        assertEquals(100.0, record.getInputValue(), DELTA);
        assertEquals(1, record.getSourceUnitId());
        assertEquals(212.0, record.getOutputValue(), DELTA);
        assertEquals(2, record.getTargetUnitId());
    }

    @Test
    void testSecondaryConstructor() {
        TempRecord record = new TempRecord(0.0, 2, -17.78, 1);

        assertEquals(0, record.getId());
        assertEquals(0.0, record.getInputValue(), DELTA);
        assertEquals(2, record.getSourceUnitId());
        assertEquals(-17.78, record.getOutputValue(), DELTA);
        assertEquals(1, record.getTargetUnitId());
    }
}
