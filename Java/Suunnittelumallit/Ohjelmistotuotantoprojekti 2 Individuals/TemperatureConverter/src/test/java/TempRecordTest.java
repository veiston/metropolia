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
        assertEquals("en", record.getLanguage());
        assertEquals("", record.getTimestamp());
    }

    @Test
    void testConstructorWithLanguageAndTimestamp() {
        TempRecord record = new TempRecord(1, 100.0, 1, 212.0, 2, "ja", "2026-11-06 00:00:00");

        assertEquals(1, record.getId());
        assertEquals(100.0, record.getInputValue(), DELTA);
        assertEquals(1, record.getSourceUnitId());
        assertEquals(212.0, record.getOutputValue(), DELTA);
        assertEquals(2, record.getTargetUnitId());
        assertEquals("ja", record.getLanguage());
        assertEquals("2026-11-06 00:00:00", record.getTimestamp());
    }

    @Test
    void testSecondaryConstructor() {
        TempRecord record = new TempRecord(0.0, 2, -17.78, 1);

        assertEquals(0, record.getId());
        assertEquals(0.0, record.getInputValue(), DELTA);
        assertEquals(2, record.getSourceUnitId());
        assertEquals(-17.78, record.getOutputValue(), DELTA);
        assertEquals(1, record.getTargetUnitId());
        assertEquals("en", record.getLanguage());
        assertEquals("", record.getTimestamp());
    }

    @Test
    void testSecondaryConstructorWithLanguageAndTimestamp() {
        TempRecord record = new TempRecord(0.0, 2, -17.78, 1, "fi", "2026-11-06 01:00:00");

        assertEquals(0, record.getId());
        assertEquals(0.0, record.getInputValue(), DELTA);
        assertEquals(2, record.getSourceUnitId());
        assertEquals(-17.78, record.getOutputValue(), DELTA);
        assertEquals(1, record.getTargetUnitId());
        assertEquals("fi", record.getLanguage());
        assertEquals("2026-11-06 01:00:00", record.getTimestamp());
    }
}
