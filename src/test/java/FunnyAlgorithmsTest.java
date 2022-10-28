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
}