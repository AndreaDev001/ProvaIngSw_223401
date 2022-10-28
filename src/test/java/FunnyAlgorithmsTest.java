import org.joda.time.DateTime;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

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
        System.out.println("Test" + " " + "started at" + " " + new DateTime());
    }
    @After
    public void after()
    {
        System.out.println("Test" + " " +  "ended at" + " " + new DateTime());
    }
    /***@Test
    public void binaryShouldWork()
    {
        int[] values = {10,20,30,40,50,60};
        for(int i = 0;i < values.length;i++)
            assertEquals(i,funnyAlgorithms.binarySearch(values,values[i]));
    }**/
    @Test
    public void binaryShouldFail()
    {
        int[] values = {10,20,30,40,50};
        for(int i = 60;i < 120;i += 10)
            assertEquals(-1,funnyAlgorithms.binarySearch(values,i));
    }
    @Test
    public void swapWorks()
    {
        int[] first = {10,20,30};
        FunnyAlgorithms.swap(first,0,1);
        assertEquals(20,first[0]);
        FunnyAlgorithms.swap(first,2,1);
        assertEquals(30,first[1]);
    }
    @Test
    public void selectionWorks()
    {
        int[] values = {60,10,30,40,50,80};
        funnyAlgorithms.selectionSort(values,1);
        boolean ascending = true;
        for(int i = 1;i < values.length;i++)
        {
            int current = values[i];
            int precedente = values[i - 1];
            if(precedente > current)
            {
                ascending = false;
                break;
            }
        }
        assertTrue(ascending);
        funnyAlgorithms.selectionSort(values,0);
        boolean descending = true;
        for(int i = 1;i < values.length;i++)
        {
            int current = values[i];
            int precedente = values[i - 1];
            if(precedente < current)
            {
                descending = false;
                break;
            }
        }
        assertTrue(descending);
    }
    @Test
    public void selectionShouldFail()
    {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("L'ordine può essere 0 o 1.");
        int[] values = {10,100,20,50,70};
        funnyAlgorithms.selectionSort(values,10);
    }
    @Test
    public void stringToIntWorks()
    {
        String[] values = {"10","30","400","200","40","80","-20","-30","-40"};
        assertEquals(10,funnyAlgorithms.stringToIntConverter(values[0]));
        assertEquals(30,funnyAlgorithms.stringToIntConverter(values[1]));
        assertEquals(400,funnyAlgorithms.stringToIntConverter(values[2]));
        assertEquals(200,funnyAlgorithms.stringToIntConverter(values[3]));
        assertEquals(40,funnyAlgorithms.stringToIntConverter(values[4]));
        assertEquals(80,funnyAlgorithms.stringToIntConverter(values[5]));
        assertEquals(-20,funnyAlgorithms.stringToIntConverter(values[6]));
        assertEquals(-30,funnyAlgorithms.stringToIntConverter(values[7]));
        assertEquals(-40,funnyAlgorithms.stringToIntConverter(values[8]));
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
    public void stringToIntWithLetters()
    {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Number can be composed only by digits");
        String number = "10abc20";
        int value = funnyAlgorithms.stringToIntConverter(number);
    }
    @Test
    public void stringToIntWithSpecialChar()
    {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Number can be composed only by digits");
        String number = "10!|_20";
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