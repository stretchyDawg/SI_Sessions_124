package si;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculonTest {
    @Test
    public void testAdd(){
        // setup
        double number1 = 1;
        double number2 = 3;
        double expected = 4.0;

        // invoke
        double actual = Calculon.add(number1, number2);

        // analyze
        assertEquals(expected, actual);
    }
}
