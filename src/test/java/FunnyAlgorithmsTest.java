import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunnyAlgorithmsTest
{
    private FunnyAlgorithms funnyAlgorithms;

    @Before
    public void before()
    {
        funnyAlgorithms = new FunnyAlgorithms();
    }
    @Test(expected = IllegalArgumentException.class)
    public void stringToIntNull()
    {
        String number = "";
        int value = funnyAlgorithms.stringToIntConverter(number);
    }
}