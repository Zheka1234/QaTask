package homework2.testNg;

import com.miskevich.homework1.service.impl.NumberInputImpl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

@Listeners(MyListenerCalculatorTestNg.class)
public class InputTestNgTest {
    private NumberInputImpl numberInput;

    @BeforeClass
    public void setUp() {
        numberInput = new NumberInputImpl();
    }

    @AfterClass
    public void tearDown() {
        numberInput = null;
    }

    @DataProvider(name = "validInputData")
    public Object[][] validInputData() {
        return new Object[][]{
                {"5,7\n2,3", 5.7, 2.3},
                {"3,14\n1,5", 3.14, 1.5},

        };
    }

    @DataProvider(name = "invalidInputData")
    public Object[][] invalidInputData() {
        return new Object[][]{
                {"abc\n1\nabc\n5", 1, 5},
                {"xyz\n2\nxyz\n4", 2, 4},

        };
    }

    @Test(dataProvider = "validInputData", groups = "calculator")
    public void testGetNumberInput_ValidInput(String input, double expected1, double expected2) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner reader = new Scanner(System.in);
        double result1 = numberInput.getNumberInput(reader, "Enter the first number: ");
        double result2 = numberInput.getNumberInput(reader, "Enter the second number: ");
        Assert.assertEquals(result1, expected1);
        Assert.assertEquals(result2, expected2);
    }

    @Test(dataProvider = "invalidInputData", groups = "calculator")
    public void testGetNumberInput_InvalidInput(String input, double expected1, double expected2) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner reader = new Scanner(System.in);
        double result1 = numberInput.getNumberInput(reader, "Enter the first number: ");
        Assert.assertEquals(result1, expected1, "Error: Invalid input. Please try again.");
        double result2 = numberInput.getNumberInput(reader, "Enter the second number: ");
        Assert.assertEquals(result2, expected2, "Error: Invalid input. Please try again.");
    }
}