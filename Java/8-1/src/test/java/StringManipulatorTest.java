import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {

    private final StringManipulator sm = new StringManipulator();

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", sm.concatenate("Hello", "World"));
        assertEquals("Hello", sm.concatenate("Hello", ""));
        assertEquals("", sm.concatenate("", ""));
    }

    @Test
    void testFindLength() {
        assertEquals(5, sm.findLength("Hello"));
        assertEquals(0, sm.findLength(""));
        assertEquals(3, sm.findLength("abc"));
    }

    @Test
    void testConvertToUpperCase() {
        assertEquals("HELLO", sm.convertToUpperCase("hello"));
        assertEquals("HELLO", sm.convertToUpperCase("Hello"));
        assertEquals("", sm.convertToUpperCase(""));
    }

    @Test
    void testConvertToLowerCase() {
        assertEquals("hello", sm.convertToLowerCase("HELLO"));
        assertEquals("hello", sm.convertToLowerCase("Hello"));
        assertEquals("", sm.convertToLowerCase(""));
    }

    @Test
    void testContainsSubstring() {
        assertTrue(sm.containsSubstring("Hello World", "World"));
        assertTrue(sm.containsSubstring("Hello World", ""));
        assertFalse(sm.containsSubstring("Hello", "World"));
    }
}
