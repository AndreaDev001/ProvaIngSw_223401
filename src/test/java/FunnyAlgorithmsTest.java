import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class FunnyAlgorithmsTest
{
    private FunnyAlgorithms funnyAlgorithms;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before()
    {
        funnyAlgorithms = new FunnyAlgorithms();
    }
    @Test
    public void stringToIntNull()
    {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Number can't be null");
        String number = "";
        int value = funnyAlgorithms.stringToIntConverter(number);
    }
    @Test
    public void stringToIntWithSpace()
    {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Number can be composed only by digits");
        String value = "10 20 30 40 50";
        int result = funnyAlgorithms.stringToIntConverter(value);
    }
    @Test
    public void stringToIntRangeUpper()
    {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Required number is out of range");
        String value = "32768";
        int result = funnyAlgorithms.stringToIntConverter(value);
    }
    @Test
    public void stringToIntRangeLower()
    {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Required number is out of range");
        String value = "-32770";
        int result = funnyAlgorithms.stringToIntConverter(value);
    }
}